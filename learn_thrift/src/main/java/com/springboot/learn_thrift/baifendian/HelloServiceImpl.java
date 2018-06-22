package com.springboot.learn_thrift.baifendian;

import com.springboot.learn_thrift.service.Hello;
import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "result:"+para;
    }
}
