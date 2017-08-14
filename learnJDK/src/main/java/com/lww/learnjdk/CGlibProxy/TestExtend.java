package com.lww.learnjdk.CGlibProxy;

/**
 * Created by lenovo on 2017/8/10.
 */
public class TestExtend {
    public static void main(String[] a) {
        ExtendSomeClass esc = new ExtendSomeClass();
        SomeClass sc = (SomeClass) esc;
        sc.doSomething();
    }
}
