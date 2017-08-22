package com.lww.nettyspring;

import com.lww.nettyspring.server.DomyServer;
import com.lww.nettyspring.server.DomyServerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by lenovo on 2017/8/21.
 */
public class StartServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        String s = applicationContext.getResource("classpath:spring.xml").getURI().toString();
//        System.out.println(s);

        DomyServer domyServer = (DomyServer) applicationContext.getBean("domyServer");

        domyServer.start();
    }
}
