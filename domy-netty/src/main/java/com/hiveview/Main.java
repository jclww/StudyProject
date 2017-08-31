package com.hiveview;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lww on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        //  Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
    }
}
