package com.lww.pattern.factory;

/**
 * 简单工厂模式
 */
public class SimpleFactory {

    public static void main(String[] args) {
        BaseObject object = Factory.getObjectByAlias("Object1");
        if (object != null) {
            object.doSomething();
        }
    }
}

interface BaseObject {
    void doSomething();
}

class Object1 implements BaseObject {
    @Override
    public void doSomething() {
        System.out.println("Object1" + this.getClass());
    }
}

class Object2 implements BaseObject {
    @Override
    public void doSomething() {
        System.out.println("Object2" + this.getClass());
    }
}

class Factory {
    public static BaseObject getObjectByAlias(String alias) {
        if ("Object1".equals(alias)) {
            return new Object1();
        } else if ("Object2".equals(alias)) {
            return new Object2();
        } else {
            return null;
        }
    }
}

