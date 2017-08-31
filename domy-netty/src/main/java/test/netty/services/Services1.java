package test.netty.services;

import com.hiveview.protobuf.DomyReqMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.netty.services.connect.DomyNettyConnect;

/**
 * Created by Lww on 2017/8/25.
 */
public class Services1 {
    public static void main(String[] a) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-server.xml");
        DomyNettyConnect connect = (DomyNettyConnect) context.getBean("domyServer1");
        DomyReqMessage.DomyRequest.Builder builder = DomyReqMessage.DomyRequest
                .newBuilder();
        builder.setType(3);
        builder.setMac("111");
        builder.setSn("qqq");
        builder.setMessageBody("Hello This is Push Message!!!");
//        ctx.writeAndFlush(builder);

        connect.sendMessage(builder);

        context.registerShutdownHook();
    }
}
