package com.lww.nettyspring.disruptor.executor;

import io.netty.channel.Channel;

/**
 * Created by lenovo on 2017/8/23.
 */
public class DomyExecutor implements BaseExecutor {
    private Channel ch;
    private Object msg;

    public DomyExecutor(Channel ch, Object msg) {
        this.ch = ch;
        this.msg = msg;

    }

    public void onExecute() throws Exception {
        System.out.println("asdasdsa"+msg);
        if (null == msg) {
            throw new NullPointerException("msg");
        }
        ch.writeAndFlush(msg);
    }
    public void release() {
        this.ch = null;
        this.msg = null;
    }
}
