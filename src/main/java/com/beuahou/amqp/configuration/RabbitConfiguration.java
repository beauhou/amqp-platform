package com.beuahou.amqp.configuration;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author: BeauHou
 * @Date: 2022/7/16
 * @Description:
 */
@Configuration
public class RabbitConfiguration {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MessageProducer messageProducer;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @PostConstruct
    public void init() {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(messageProducer);
        rabbitTemplate.setReturnCallback(messageProducer);
    }

}
