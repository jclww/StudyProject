package test.netty.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lww on 2017/8/25.
 */
public class Client1 {
    public static void main(String[] a) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");
        context.registerShutdownHook();
    }
}
