package com.lww.nettyspring.netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.ExecutorService;

/**
 * Created by lenovo on 2017/8/21.
 */
public class ThreadHandle extends SimpleChannelInboundHandler {
    ExecutorService blockingIOProcessor ;

    public ThreadHandle(ExecutorService blockingThreadPool) {
        this.blockingIOProcessor = blockingThreadPool;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("1111111111");
        blockingIOProcessor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting.");

                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println("Finished.");
            }
        });
        System.out.println("2222222");
    }
}
