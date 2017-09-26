package com.lww.learnjdk.thread;

/**
 * Created by Lww on 2017/9/25.
 */
public class TestCPU {
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(10000L);

        for (int i = 0;i<5;i++) {
            new Thread(new RunThread(),i+"").start();
        }
    }
}
