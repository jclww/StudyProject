package com.lww.learnjdk.CGlibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/8/8.
 */
public class CGlibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {

        this.target = target;
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("..........before..........");
        proxy.invokeSuper(obj, args);
        System.out.println("..........after ..........");
        return null;
    }
}
