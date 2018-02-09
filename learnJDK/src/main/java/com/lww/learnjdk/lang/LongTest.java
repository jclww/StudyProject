package com.lww.learnjdk.lang;

public class LongTest {
    public static void main(String[] args) {
//        Long a = null;
//        System.out.println( a == 0);
        LongTest l = new LongTest();
        l.method();

    }
    public void method() {
        A a = new A();
        System.out.println(a.a != 0);
    }
    class A {
        Long a;
    }
}
