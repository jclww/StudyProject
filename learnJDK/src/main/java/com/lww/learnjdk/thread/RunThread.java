package com.lww.learnjdk.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Lww on 2017/9/21.
 */
public class RunThread implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private static int a = 0;
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            lock.lock();
                a++;
//                System.out.println(Thread.currentThread().getName()+":"+a);
            lock.unlock();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
