package com.beuahou.amqp.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beuahou.amqp.constant.MessageConstant;
import com.beuahou.amqp.entity.QueueMessageEntity;
import com.beuahou.amqp.mapper.QueueMessageMapper;
import com.beuahou.amqp.vo.QueueMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: BeauHou
 * @Date: 2022/7/17
 * @Description:
 */
@Service
public class QueueMessageService {

    @Autowired
    private QueueMessageMapper queueMessageMapper;

    /**
     * 通过 messageId发现消息
     *
     * @param messageId 消息id
     * @return 查询结果
     */
    public QueueMessageEntity findSingleByMessageId(String messageId) {
        QueryWrapper<QueueMessageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("messageId", messageId);
        QueueMessageEntity queueMessageEntity = queueMessageMapper.selectOne(queryWrapper);
        return queueMessageEntity;
    }

    /**
     * 查找消息并将消息设置为处理失败
     *
     * @param messageId 消息id
     * @return true表示处理成功
     */
    public boolean findAndFailMessage(String messageId, String remark) {
        QueueMessageEntity queueMessageEntity = findSingleByMessageId(messageId);
        if (ObjectUtil.isNotNull(queueMessageEntity)) {
            queueMessageEntity.setStatus(MessageConstant.MessageStatus.sendFail.getValue());
            queueMessageEntity.setRemark(remark);
            queueMessageMapper.updateById(queueMessageEntity);
            return true;
        }
        return false;
    }


    /**
     * 查找消息并将消息设置为处理失败
     *
     * @param messageId 消息id
     * @return true表示处理成功
     */
    public boolean findAndSuccessMessage(String messageId) {
        QueueMessageEntity queueMessageEntity = findSingleByMessageId(messageId);
        if (ObjectUtil.isNotNull(queueMessageEntity)) {
            queueMessageEntity.setStatus(MessageConstant.MessageStatus.send_success.getValue());
            queueMessageMapper.updateById(queueMessageEntity);
            return true;
        }
        return false;
    }

    /**
     * 保存消息
     *
     * @param queueMessageVo 消息对象
     */
    public void save(QueueMessageVo queueMessageVo) {
        QueueMessageEntity queueMessageEntity = BeanUtil.copyProperties(queueMessageVo, QueueMessageEntity.class);
        queueMessageMapper.insert(queueMessageEntity);
    }
}
