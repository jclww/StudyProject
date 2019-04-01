package com.lww.other.callback;

public class Main {
    public static void main(String[] args) {

        Caller caller = new Caller();
        // 设置消息处理对象
        caller.setNotifier(new Notifier());
        // 设置消息回掉处理
        caller.setCallBackListener(msg -> System.out.println("我收到反馈:" + msg));
        // 发送消息
        caller.doSomeThing("Hello");
    }
}
