package com.lww.learnjdk.thread.mian;

import com.lww.learnjdk.thread.CallThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Lww on 2017/9/21.
 */
public class CallThreadTest {
    public static void main(String[] args) {
        CallThread thread = new CallThread();
        FutureTask<Integer> future = new FutureTask<Integer>(thread);
        new Thread(future).start();

        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));
            System.out.println("asda");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
