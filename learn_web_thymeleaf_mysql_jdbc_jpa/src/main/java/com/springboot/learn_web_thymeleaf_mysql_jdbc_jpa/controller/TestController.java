package com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.controller;

import com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.bean.Person;
import com.springboot.learn_web_thymeleaf_mysql_jdbc_jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    /*===============JPA=================*/
    @RequestMapping("/jpa/save")
    public ModelAndView save(){
        ModelAndView modelAndView=new ModelAndView("index");
        Person person=new Person();
        person.setName("张三");
        person.setAge(18);
        personRepository.save(person);
        modelAndView.addObject("person",person);
        return modelAndView;
    }

    @RequestMapping("/jpa/select")
    public ModelAndView select(){
        ModelAndView modelAndView=new ModelAndView("index2");
        List<Person> list=personRepository.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    /*===============JdbcTemplate=================*/

    @RequestMapping("/jdbc/save")
    public ModelAndView jdbcSave(){
        ModelAndView modelAndView=new ModelAndView("index");
        Person person=new Person();
        person.setName("李四");
        person.setAge(28);
        person.setId(20);
        String sql="insert into person(id,name,age) values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{person.getId(),person.getName(),person.getAge()});
        modelAndView.addObject("person",person);
        return modelAndView;
    }

    @RequestMapping("/jdbc/select")
    public ModelAndView jdbcSelect(){
        ModelAndView modelAndView=new ModelAndView("index2");
        List<Map<String, Object>> people=jdbcTemplate.queryForList("select * from person");
        List<Person> personList=new ArrayList<>();
        for(Map<String,Object> map:people){
            Person person=new Person();
            person.setId(Integer.parseInt(map.get("id").toString()));
            person.setName(map.get("name").toString());
            person.setAge(Integer.parseInt(map.get("age").toString()));
            personList.add(person);
        }
        System.out.println(personList);
        modelAndView.addObject("list",personList);
        return modelAndView;
    }

}
