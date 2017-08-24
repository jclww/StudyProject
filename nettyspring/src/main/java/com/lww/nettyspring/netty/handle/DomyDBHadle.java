package com.lww.nettyspring.netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by lenovo on 2017/8/21.
 */
public class DomyDBHadle extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("111111");
        Thread.sleep(2000);
        System.out.println("222222");
        ctx.fireChannelRead(msg);
    }
}
