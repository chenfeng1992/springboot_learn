package com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.controller;

import com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.bean.Person;
import com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public ModelAndView save(){
        ModelAndView modelAndView=new ModelAndView("index");
        Person person=new Person();
        person.setName("张三");
        person.setAge(18);
        personRepository.save(person);
        modelAndView.addObject("person",person);
        return modelAndView;
    }

    @RequestMapping("/select")
    public ModelAndView select(){
        ModelAndView modelAndView=new ModelAndView("index2");
        List<Person> list=personRepository.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }


}
