package com.lww.learnjdk.JDKProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;

/**
 * Created by lenovo on 2017/8/8.
 */
public class TestJDKProxy {
    public static void main(String[] a) {
        // 实例化目标对象
        Service userService = new ServiceImpl();

        // 实例化InvocationHandler
        JDKInvocationHandler invocationHandler = new JDKInvocationHandler(userService);

        // 根据目标对象生成代理对象
        Service proxy = (Service) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.say();
        writeProxyClassToHardDisk("/data/$Proxy11.class");
    }
    public static void writeProxyClassToHardDisk(String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", ServiceImpl.class.getInterfaces());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
