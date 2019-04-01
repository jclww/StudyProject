package com.lww.pattern.factory;

/**
 * 适用于多维度
 * 将Object工厂也抽象化
 * eg:
 * 先获取工厂类 ： FactoryProducer.getFactory("factory1");
 *
 * 根据工厂类再获取实例 ： factory1.getObject("object1");
 *
 * 抽象维度太高，不太常用（我觉得...）
 *
 */
public class AbstractFactory {
}
