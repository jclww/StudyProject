package com.lww.other.callback;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Caller {
    private CallBackListener callBackListener;
    private Notifier notifier;

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), r -> {
        Thread t = new Thread();
        t.setName("test");
        return t;
    }) {
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
        }
    };



    public void doSomeThing(String value) {
        System.out.println("I`m doSomeThing Now ~~");
        poolExecutor.execute(() -> notifier.execute(Caller.this, value));
        System.out.println("I`m over ~~");
        poolExecutor.shutdownNow();

    }

    public CallBackListener getCallBackListener() {
        return callBackListener;
    }

    public void setCallBackListener(CallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }
}
