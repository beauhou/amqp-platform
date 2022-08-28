package com.beuahou.amqp.model;


import java.io.Serializable;

/**
 * @author: BeauHou
 * @Date: 2022/7/16
 * @Description:
 */

public class MessageRequestModel implements  Serializable {

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 路由键
     */
    private String routerKey;

    /**
     * 队列
     */
    private String exchange;

    /**
     * 消息对象
     */
    private Object messageObj;


    public String getRouterKey() {
        return routerKey;
    }

    public void setRouterKey(String routerKey) {
        this.routerKey = routerKey;
    }


    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Object getMessageObj() {
        return messageObj;
    }

    public void setMessageObj(Object messageObj) {
        this.messageObj = messageObj;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
