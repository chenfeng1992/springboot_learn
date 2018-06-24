package com.springboot.learn_web_rabbitmq.demo1.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class Demo1Controller {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/hello")
    public void hello(){
        rabbitTemplate.convertAndSend("user","hello");
    }

}
