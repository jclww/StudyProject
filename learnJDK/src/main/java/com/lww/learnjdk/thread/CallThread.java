package com.lww.learnjdk.thread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Lww on 2017/9/21.
 */
public class CallThread implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return new Random().nextInt(100);
    }
}
