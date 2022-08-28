package com.beuahou.amqp.controller;


import cn.hutool.http.HttpStatus;
import com.beuahou.amqp.constant.HttpResult;
import com.beuahou.amqp.model.MessageRequestModel;
import com.beuahou.amqp.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: BeauHou
 * @Date: 2022/7/16
 * @Description:
 */
@RestController
@RequestMapping("amqp")
public class AmqpController {

    @Autowired
    AmqpService amqpService;

    @PostMapping("sendAmqpMessage")
    public HttpResult sendAmqpMessage(@RequestBody MessageRequestModel messageRequestModel) {
        amqpService.sendMessage(messageRequestModel);
        return success();
    }


    /**
     * 构建成功示例
     *
     * @return
     */
    private HttpResult success() {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(HttpStatus.HTTP_OK);
        httpResult.setMessage("success");
        return httpResult;
    }
}
