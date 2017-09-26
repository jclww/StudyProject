package com.lww.learnjdk.thread;

/**
 * Created by Lww on 2017/9/21.
 */
public class ThrThread extends Thread {
    public ThrThread(Runnable target) {
        super(target);
    }
        @Override
    public void run() {
        System.out.println("ThrThread");
    }
}
