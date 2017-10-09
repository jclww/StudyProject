package com.lww.learnjdk.thread.mian.pool;

import com.lww.learnjdk.thread.RunThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Lww on 2017/9/21.
 */
public class PoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);


        RunThread thread = new RunThread();
        poolExecutor.execute(thread);
        poolExecutor.execute(thread);
        poolExecutor.submit(thread);
        poolExecutor.shutdown();
    }
}
