package com.lww.learnjdk.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> c = TestClassA.class;
        TestClassA testClassA = (TestClassA)c.newInstance();

        TestClassA testClassA1 = new TestClassA();
        c.getDeclaredField("publicInt").set(testClassA, 123);
        c.getDeclaredField("publicInt").set(testClassA1, 22223);
        c.getDeclaredField("publicString").set(testClassA, "testClassA");
        c.getDeclaredField("publicString").set(testClassA1, "testClassA1");

        System.out.println(testClassA);
        System.out.println(testClassA1);

        Constructor<?> con=TestClassA.class.getConstructor();
        Object mathobj=con.newInstance();

        testArray();
    }

    public static void testArray() {
        Class<?> cls = null;
        try {
            cls = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));
    }
}
