package com.lww.learnjdk.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lww on 2017/9/21.
 */
public class MyThreadPool {
    private ThreadPoolExecutor threadPoolExecutor;

    public MyThreadPool() {
        this(4);
    }
    public MyThreadPool(int poolSize) {
        this.threadPoolExecutor = new ThreadPoolExecutor(poolSize,
                poolSize,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
    public void execute(Runnable command) {
        try {
            threadPoolExecutor.execute(command);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException e) {

        }
    }
    public void clear() {
        threadPoolExecutor.shutdown();
    }
    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

}
