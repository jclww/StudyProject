package com.lww.learn.ThreadTest;

/**
 * Created by lenovo on 2017/7/27.
 */
public class TestLedis {
    public static void main(String[] a)
    {
        for (int i=0;i<5;i++)
        {
            new Thread(new ConcurrentTest(),i+"").start();
        }
    }
}
