package com.lww.netty.secureChat;


import io.netty.channel.Channel;

/**
 * Created by lenovo on 2017/8/18.
 */
public class TestThread implements Runnable {
    private Channel c;

    public TestThread(Channel ch) {
        this.c = ch;
    }

    @Override
    public void run() {
        try {
            System.out.println("******start*******");
            Thread.sleep(5000);
            c.writeAndFlush("[" +  "] " + "Hello" + '\n');
            System.out.println("******end*******");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
