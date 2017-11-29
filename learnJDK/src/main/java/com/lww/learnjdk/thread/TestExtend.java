package com.lww.learnjdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Lww on 2017/11/27.
 */
public class TestExtend {
    public static void main(String[] args) {
        ExecutorService poolExecutor = Executors.newFixedThreadPool(2);

        poolExecutor.shutdown();


        A a = new A();
        a.onShutdown();
    }
}

class A {
    public void methodA() {
        System.out.println("methodA");
    }
    void onShutdown() {
    }

}
class B extends A {
    @Override
    void onShutdown() {
        System.out.println("onShutdown");
    }
}

