package com.beuahou.amqp.configuration;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.beuahou.amqp.model.MessageRequestModel;
import com.beuahou.amqp.service.QueueMessageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: BeauHou
 * @Date: 2022/7/18
 * @Description:
 */
@Component
public class MessageProducer implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    QueueMessageService queueMessageService;


    /**
     * 不管成功于否，都会调用。
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String messageId = correlationData.getId();
        if (ack) {
            queueMessageService.findAndSuccessMessage(messageId);
        } else {
            queueMessageService.findAndFailMessage(messageId, cause);
        }
    }

    /**
     * 如果消息未从路由成功发送到队列那么会走这个回调，这里会把消息的整个明细返回
     * 　　　* 也就是说出错了，才会调用哦。
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        MessageRequestModel messageRequestModel = JSONUtil.toBean(new String(message.getBody()), MessageRequestModel.class);
        queueMessageService.findAndFailMessage(messageRequestModel.getMessageId(), replyText);
    }
}