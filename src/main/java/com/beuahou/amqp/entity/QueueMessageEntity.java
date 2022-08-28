package com.beuahou.amqp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.beauhou.core.base.entity.BaseEntity;
import com.beauhou.core.base.vo.BaseVo;

/**
 * @author: BeauHou
 * @Date: 2022/7/17
 * @Description:
 */
@TableName("queue_message")
public class QueueMessageEntity extends BaseEntity {

    /**
     * id
     */
    private Long id;


    /**
     * 消息id
     */
    private String messageId;

    /**
     * 消息对象
     */
    private String messageObj;

    /**
     * 路由器
     */
    private String exchange;


    /**
     * 路由键
     */
    private String routerKey;

    /**
     * 状态 status=1，发送中  status=2发送成功 ，status=3 发送失败
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    @Override
    public Long getPrimaryKey() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageObj() {
        return messageObj;
    }

    public void setMessageObj(String messageObj) {
        this.messageObj = messageObj;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRouterKey() {
        return routerKey;
    }


    public void setRouterKey(String routerKey) {
        this.routerKey = routerKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
