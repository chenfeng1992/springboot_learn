package com.springboot.learn_thrift.baifendian;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;

public class ThriftService {
    public static void main(String[] args){
        String[] configs = new String[] { "classpath:server.properties"  };  // 配置文件路径
        HelloServiceImpl impl = new HelloServiceImpl();


    }
}
