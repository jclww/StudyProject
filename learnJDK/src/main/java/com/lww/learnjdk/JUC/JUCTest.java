package com.lww.learnjdk.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lww on 2017/8/29.
 */
public class JUCTest {
    public static void main(String[] a) {
        ExecutorService cachedService = Executors.newCachedThreadPool();
        ExecutorService fixedService = Executors.newFixedThreadPool(16);
        ExecutorService scheduledService = Executors.newScheduledThreadPool(8);
        ExecutorService singleService = Executors.newSingleThreadExecutor();

    }
}
