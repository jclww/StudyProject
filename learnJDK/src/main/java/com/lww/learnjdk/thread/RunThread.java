package com.lww.learnjdk.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Lww on 2017/9/21.
 */
public class RunThread implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private int a = 0;
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1 << 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
                a++;
                System.out.println(Thread.currentThread().getName()+":"+a);
            lock.unlock();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
