package com.lww.learnjdk.thread.mian.pool;

import com.lww.learnjdk.thread.RunThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Lww on 2017/9/21.
 */
public class PoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8,
                2, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(4), new TestThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);






        RunClass runClass = new RunClass();

        ExceptionClass exceptionClass = new ExceptionClass();
        threadPoolExecutor.execute(exceptionClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(exceptionClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(exceptionClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(exceptionClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(runClass);
        threadPoolExecutor.submit(exceptionClass);
        threadPoolExecutor.submit(runClass);


        threadPoolExecutor.shutdown();
    }

    static class ExceptionClass implements Runnable {
        @Override
        public void run() {
            throw new IllegalArgumentException("exception");
        }
    }

    static class RunClass implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // do nothing
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    static class TestThreadFactory implements ThreadFactory {
        private String threadNamePrefix = "pool-";
        private static AtomicInteger threadNameNumber = new AtomicInteger();

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(threadNamePrefix + threadNameNumber.getAndIncrement());
            return thread;
        }
    }
}
