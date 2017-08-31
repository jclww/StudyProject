package test.netty.nettyServer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lww on 2017/8/25.
 */
public class Server1 {
    public static void main(String[] args) {
        //  Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
    }
}
