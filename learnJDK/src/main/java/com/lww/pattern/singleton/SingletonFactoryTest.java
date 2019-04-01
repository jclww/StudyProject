package com.lww.pattern.singleton;

public class SingletonFactoryTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> SimpleSingletonFactory.getObject("Object1").doSomething()).start();
        new Thread(() -> SimpleSingletonFactory.getObject("Object1").doSomething()).start();
        new Thread(() -> SimpleSingletonFactory.getObject("Object1").doSomething()).start();
        new Thread(() -> SimpleSingletonFactory.getObject("Object1").doSomething()).start();
    }
}

class SimpleSingletonFactory {
    public static BaseObject getObject(String alias) {
        if ("Object1".equals(alias)) {
            return Object1Factory.getObject();
        } else if ("Object2".equals(alias)) {
            return Object2Factory.getObject();
        } else {
            return null;
        }
    }
}

class Object1Factory {
    private static volatile Object1 object = null;

    public static Object1 getObject() {
        if (object == null) {
            synchronized (Object1Factory.class) {
                // double check
                if (object == null) {
                    object = new Object1();
                }
            }
        }
        return object;
    }
}
class Object2Factory {
    private static volatile Object2 object = null;

    public static Object2 getObject() {
        if (object == null) {
            synchronized (Object2Factory.class) {
                // double check
                if (object == null) {
                    object = new Object2();
                }
            }
        }
        return object;
    }
}


interface BaseObject {
    void doSomething();
}
class Object1 implements BaseObject{
    @Override
    public void doSomething() {
        System.out.println(this + "\t Object1#doSomething");
    }
}
class Object2 implements BaseObject{
    @Override
    public void doSomething() {
        System.out.println(this + "\t Object3#doSomething");
    }
}

