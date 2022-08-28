package com.beuahou.amqp.constant;

/**
 * @author: BeauHou
 * @Date: 2022/7/17
 * @Description:
 */
public class MessageConstant {

    public static enum MessageStatus {

        sending(1, "发送中"),
        send_success(2, "发送成功"),
        sendFail(3, "发送失败");

        MessageStatus(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        private Integer value;

        private String label;

    }
}
