package com.lww.other.callback;

import java.util.concurrent.TimeUnit;

public class Notifier {
    public void execute(Caller caller, String msg){

        System.out.println("我收到了消息:" + msg + ",我处理一下!");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("我处理完了, 现在告诉你结果 ~");

        caller.getCallBackListener().callBackNotify("Hello World");
    }
}
