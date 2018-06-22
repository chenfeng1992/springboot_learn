package com.springboot.learn_thrift.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * 客户端
 */
public class ClientMain {
    public static void main(String[] args){
        System.out.println("客户端启动");
        TTransport tTransport=null;
        try{
            tTransport=new TSocket("localhost",9898,30000);
            //协议要和服务器一致
            TProtocol tProtocol=new TBinaryProtocol(tTransport);
            Hello.Client client=new Hello.Client(tProtocol);
            tTransport.open();
            String result=client.helloString("哈哈");
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != tTransport){
                tTransport.close();
            }
        }
    }
}
