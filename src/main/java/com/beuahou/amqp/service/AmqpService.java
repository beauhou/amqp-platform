package com.beuahou.amqp.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.beuahou.amqp.constant.MessageConstant;
import com.beuahou.amqp.entity.QueueMessageEntity;
import com.beuahou.amqp.model.MessageRequestModel;
import com.beuahou.amqp.vo.QueueMessageVo;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * amqp消息服务
 *
 * @author: BeauHou
 * @Date: 2022/7/16
 * @Description:
 */
@Service
public class AmqpService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    QueueMessageService queueMessageService;


    /**
     * 发送可靠消息
     *
     * @param messageRequestModel
     */
    public void sendMessage(MessageRequestModel messageRequestModel) {

        //组装消息内容
        String messageId = UUID.fastUUID().toString();

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(messageId);
        messageRequestModel.setMessageId(messageId);
        //发送消息
        rabbitTemplate.convertAndSend(messageRequestModel.getExchange(),
                messageRequestModel.getRouterKey(), messageRequestModel, correlationData);
        saveMessageInfo(messageRequestModel, messageId, JSONUtil.toJsonStr(messageRequestModel.getMessageObj()));
    }

    /**
     * 发送消息
     *
     * @param messageRequestModel
     * @param messageId
     * @param messageObjStr
     */
    private void saveMessageInfo(MessageRequestModel messageRequestModel, String messageId, String messageObjStr) {
        QueueMessageVo queueMessageVo = new QueueMessageVo();
        queueMessageVo.setMessageId(messageId);
        queueMessageVo.setMessageObj(messageObjStr);
        queueMessageVo.setExchange(messageRequestModel.getExchange());
        queueMessageVo.setRouterKey(messageRequestModel.getRouterKey());
        queueMessageVo.setStatus(MessageConstant.MessageStatus.sending.getValue());
        queueMessageService.save(queueMessageVo);
    }
}
