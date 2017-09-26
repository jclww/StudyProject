package com.lww.learnjdk.thread.mian;

import com.lww.learnjdk.thread.RunThread;
import com.lww.learnjdk.thread.ThrThread;

/**
 * Created by Lww on 2017/9/21.
 */
public class ThreadMain {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
        Runnable runnable = new RunThread();
        Thread thread1 = new Thread(runnable,"1");
        Thread thread2 = new Thread(runnable,"2");
        Thread thread3 = new Thread(runnable,"3");

        thread1.start();
        thread2.start();
        thread3.start();
        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
    }
}
