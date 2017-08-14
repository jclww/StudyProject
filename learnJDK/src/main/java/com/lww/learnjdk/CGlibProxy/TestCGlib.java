package com.lww.learnjdk.CGlibProxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * Created by lenovo on 2017/8/8.
 */
public class TestCGlib {
    public static void main(String[] a) throws Exception {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\cglib");

        CGlibProxy cglib = new CGlibProxy();
        SomeClass businessObject = (SomeClass) cglib.getInstance(new SomeClass());
//        System.out.println(businessObject.getClass().getName());
//        System.out.println(businessObject.getClass().getSuperclass().getName());
        businessObject.doSomething();
    }
}
