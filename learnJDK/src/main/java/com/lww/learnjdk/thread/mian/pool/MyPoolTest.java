package com.lww.learnjdk.thread.mian.pool;

import com.lww.learnjdk.thread.RunThread;
import com.lww.learnjdk.thread.pool.MyThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Lww on 2017/9/21.
 */
public class MyPoolTest {
    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool();
        ExecutorService poolExecutor = Executors.newFixedThreadPool(4);

        RunThread thread = new RunThread();
        poolExecutor.execute(thread);
        poolExecutor.execute(thread);
        poolExecutor.submit(thread);
        poolExecutor.shutdown();
    }
}
