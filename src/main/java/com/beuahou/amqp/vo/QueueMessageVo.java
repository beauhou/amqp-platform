package com.beuahou.amqp.vo;



/**
 * @author: BeauHou
 * @Date: 2022/7/17
 * @Description:
 */
public class QueueMessageVo {

    /**
     * id
     */
    private Long id;

    /**
     * 消息对象
     */
    private String messageObj;

    /**
     * 路由器
     */
    private String exchange;

    /**
     * 消息id
     */
    private String messageId;

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

