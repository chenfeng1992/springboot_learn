package com.springboot.learn_web_mongodb.repository;

import com.springboot.learn_web_mongodb.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
