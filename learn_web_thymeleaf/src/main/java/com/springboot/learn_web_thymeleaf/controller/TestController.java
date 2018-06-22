package com.springboot.learn_web_thymeleaf.controller;

import com.springboot.learn_web_thymeleaf.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/page")
    public ModelAndView page(){
        ModelAndView modelAndView=new ModelAndView("index");
        List<Person> list=new ArrayList<>();
        Person person=new Person("1","张三",12);
        modelAndView.addObject("person",person);
        Person p1=new Person("2","李四",13);
        Person p2=new Person("3","王五",14);
        Person p3=new Person("4","赵六",15);
        Person p4=new Person("5","陈七",16);
        list.add(person);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        modelAndView.addObject("personList",list);
        return modelAndView;
    }
}
