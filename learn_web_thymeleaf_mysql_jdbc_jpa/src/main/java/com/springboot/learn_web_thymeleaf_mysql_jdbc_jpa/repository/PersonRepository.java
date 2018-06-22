package com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.repository;


import com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
