package com.lww.pattern.factory;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        ObjectFactory factory = new Object2Factory();
        BaseObject object = factory.getObject();
        object.doSomething();
    }
}


interface ObjectFactory{
    BaseObject getObject();
}
class Object1Factory implements ObjectFactory{
    @Override
    public BaseObject getObject() {
        return new Object1();
    }
}
class Object2Factory implements ObjectFactory{
    @Override
    public BaseObject getObject() {
        return new Object2();
    }
}