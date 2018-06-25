package com.springboot.learn_thrift.baifendian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThriftController {

    @Autowired
    ThriftService thriftService;

    @RequestMapping("/thrift")
    public void thrift() throws Exception {
        thriftService.thrift();
    }
}
