package com.springboot.learn_web_mongodb.controller;

import com.springboot.learn_web_mongodb.bean.User;
import com.springboot.learn_web_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mongo")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/user")
    public User user(){
        User user=new User();
        user.setName("张三");
        user.setAge(18);
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/user2")
    public List<User> user2(){
        User user=new User();
        user.setName("李四");
        user.setAge(22);
        user.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(user);
        List<User> list=mongoTemplate.findAll(User.class);
        return list;
    }

}
