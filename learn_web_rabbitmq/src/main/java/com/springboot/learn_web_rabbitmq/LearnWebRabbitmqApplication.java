package com.springboot.learn_web_rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//public class LearnWebRabbitmqApplication implements CommandLineRunner {
public class LearnWebRabbitmqApplication {

//    @Autowired
//    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(LearnWebRabbitmqApplication.class, args);
    }

//    @Bean
//    public Queue queue(){
//        return new Queue("my-queue");
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        rabbitTemplate.convertAndSend("hello","来自RabbitMQ的问候！");
//    }
}
