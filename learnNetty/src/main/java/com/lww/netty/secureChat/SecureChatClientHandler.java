package com.lww.netty.secureChat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by lenovo on 2017/8/17.
 */
public class SecureChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.err.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
        System.out.println("服务器关闭连接");
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        try {
            System.out.println(" 走到了  注销 ");
        }catch(Exception e){
            System.out.println("链接关闭时 发生异常 ");
        }
    }
}