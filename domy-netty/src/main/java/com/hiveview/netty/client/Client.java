package com.hiveview.netty.client;

import com.hiveview.protobuf.DomyReqMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lww on 2017/8/25.
 */
public class Client {
    public static void main(String[] a) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");
//        context.registerShutdownHook();
        DomyClient1 client1 = (DomyClient1) context.getBean("domyClient1");
        DomyReqMessage.DomyRequest.Builder builder = DomyReqMessage.DomyRequest.newBuilder();
        builder.setType(1);
        builder.setMac("111");
        builder.setSn("qqq");
        client1.sendMessage(builder);

    }

}
