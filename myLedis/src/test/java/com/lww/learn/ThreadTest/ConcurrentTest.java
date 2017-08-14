package com.lww.learn.ThreadTest;

import com.lww.ledis.client.BinaryClient;

/**
 * Created by lenovo on 2017/7/27.
 */
public class ConcurrentTest implements Runnable {

    public void run() {
        BinaryClient bc = new BinaryClient("120.24.91.23",6379);
        bc.setPassword("lwwredis");
        bc.connect();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        bc.close();
    }
}
