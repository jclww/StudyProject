package com.lww.pattern.singleton;


/**
 * 单例模式
 */
public class SingletonTest {
    public static void main(String[] args) {
        EagerSingleton.getTestObject().doSomething();
        LazySingleton1.getTestObject().doSomething();
        LazySingleton2.getTestObject().doSomething();

    }
}

class TestObject {
    public void doSomething() {
        System.out.println(this + "\t doSomething");
    }
}

/**
 * 饿汉式，一开始就初始化实例。
 * 线程安全
 */
class EagerSingleton {
    private static final TestObject object = new TestObject();

    public static TestObject getTestObject() {
        return object;
    }
}

/**
 * 懒汉式，第一次调用创建对象
 * 线程安全
 */
class LazySingleton1 {
    private static TestObject object = null;

    public static synchronized TestObject getTestObject() {
        if (object == null) {
            object = new TestObject();
        }
        return object;
    }
}

/**
 * 懒汉式，第一次调用创建对象
 * 线程安全
 */
class LazySingleton2 {
    private static volatile TestObject object = null;

    public static TestObject getTestObject() {
        if (object == null) {
            synchronized (LazySingleton2.class) {
                // double check
                if (object == null) {
                    object = new TestObject();
                }
            }
        }
        return object;
    }
}




