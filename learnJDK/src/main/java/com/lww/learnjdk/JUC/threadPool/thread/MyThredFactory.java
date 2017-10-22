package com.lww.learnjdk.JUC.threadPool.thread;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class MyThredFactory implements ThreadFactory{
    public MyThredFactory() {
        this(null);
    }
    public MyThredFactory(String format) {
        this.format = format;
    }
    /**
     * 原子操作计算创建线程数
     */
    private String format;

    private AtomicLong num = new AtomicLong(0);
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        if (this.format != null) {
            thread.setName(format(format, num.getAndIncrement()));
        }
        return thread;
    }
    private static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
