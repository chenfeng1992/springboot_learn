package com.springboot.learn_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnWebApplication.class, args);
    }

    @RequestMapping("/page")
    public String page(){
        return "My first page!";
    }
}
