package com.lww.nettyspring;

import com.lww.nettyspring.client.DomyClient;
import com.lww.nettyspring.server.DomyServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by lenovo on 2017/8/21.
 */
public class StartClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DomyClient domyClient = (DomyClient) applicationContext.getBean("domyClient");
        domyClient.start();
    }
}
