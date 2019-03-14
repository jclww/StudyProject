package com.lww.learnjdk.JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {
    public int num ;
    public static int count = 1000;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicMain atomicMain = new AtomicMain();


        long a = 1203212312312310031L;
        System.out.println( (int) a);

//        new Thread(() -> {
//            for (int i = 0; i < count; i++) {
//                System.out.println(atomicInteger.addAndGet(2) + Thread.currentThread().getName());
//                System.out.println("num:" + (atomicMain.num += 2)  + Thread.currentThread().getName());
//            }
//        }).start();


    }
}
