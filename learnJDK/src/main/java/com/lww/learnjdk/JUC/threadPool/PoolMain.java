package com.lww.learnjdk.JUC.threadPool;

import com.lww.learnjdk.JUC.threadPool.thread.MyThredFactory;
import com.lww.learnjdk.JUC.threadPool.thread.TestThread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class PoolMain {
    public static void main(String[] args) throws InterruptedException {
        /*
        使用Google包ThreadFactoryBuilder
         */
//        Thread.sleep(20000);
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("MyThread-%d").build();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(10), threadFactory, new ThreadPoolExecutor.AbortPolicy());
//        executor.prestartAllCoreThreads();
//        Thread.sleep(10000);

//        for (int i = 0; i < 10; i++) {
//            executor.execute(new TestThread());
//        }
//        Thread.sleep(10000);
//        executor.shutdown();
        /*
        使用自定义ThreadFactory
         */
        ThreadFactory threadFactory = new MyThredFactory("MyThread-%d");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executor.prestartAllCoreThreads();
        for (int i = 0; i < 10; i++) {
            executor.execute(new TestThread());
        }
        executor.shutdown();
    }
}
