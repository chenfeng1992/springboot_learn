package com.springboot.learn_thrift.baifendian;

import com.bfd.harpc.main.Client;
import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * 这里是客户端，需要手动启动com.springboot.learn_thrift.service.serverMain，再来启动springboot
 */
@Service
@Scope("prototype")
public class ThriftService {

    Client<Hello.Iface> client;
    Hello.Iface iface;

    @PostConstruct
    public void init() {
        try{
            String myLibraryPath=System.getProperty("user.dir");
            Resource resource=new ClassPathResource("hello.properties");
            String uri=resource.getURI().toString();
            String[] configs=null;
            if(uri.contains("classes!")){
                System.out.println("start feom jar uri= "+uri);
                configs=new String[]{"file: "+myLibraryPath+ File.separator+"config"+File.separator+"application.properties"};
            }else {
                configs=new String[]{"classpath:hello.properties"};
            }
            client=new Client<>(configs);
            iface=client.createProxy();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void thrift() throws TException {
        System.out.println(iface.helloString("thrift"));
    }
}
