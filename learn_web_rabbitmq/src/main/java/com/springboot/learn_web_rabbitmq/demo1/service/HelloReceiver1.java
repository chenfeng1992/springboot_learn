package com.springboot.learn_web_rabbitmq.demo1.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver1 {

    @RabbitListener(queues = "user")
    public void receiver(String message){
        System.out.println("Receiver < "+message+">");
    }
}
