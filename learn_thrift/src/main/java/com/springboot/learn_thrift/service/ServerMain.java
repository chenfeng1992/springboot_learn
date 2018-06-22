package com.springboot.learn_thrift.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * 服务端
 */
public class ServerMain {
    public static void main(String[] args){
        try {
            System.out.println("服务端开启...");
            TProcessor tProcessor=new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
            //简单的单线程服务模型
            TServerSocket serverPort=new TServerSocket(9898);
            TServer.Args tArgs=new TServer.Args(serverPort);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server=new TSimpleServer(tArgs);
            server.serve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
