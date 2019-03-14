package com.lww.learnjdk.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();


    public static void main(String[] args) {
        threadMethod1();
        threadMethod2();
    }
    public static void method() {
        try {
            lock.lock();

            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void threadMethod1() {
        new Thread(() -> {
            method();
        }).start();
    }
    public static void threadMethod2() {
        new Thread(() -> {
            method();

        }).start();
    }
}
