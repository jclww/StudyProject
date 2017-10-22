package com.lww.learnjdk.JUC.threadPool.thread;

public class TestThread implements Runnable {
//    private int size = 1024*1024*5;
//    private byte[] bytes = new byte[size];

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("name:"+Thread.currentThread().getName()+
                    "id:"+Thread.currentThread().getId()+
                    "num:"+i);
        }
    }
}
