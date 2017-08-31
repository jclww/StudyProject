package com.hiveview.netty.handle;

import com.hiveview.protobuf.DomyReqMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Lww on 2017/8/25.
 */
public class DomyServicesHandle extends SimpleChannelInboundHandler {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DomyReqMessage.DomyRequest.Builder builder = DomyReqMessage.DomyRequest
                .newBuilder();
        builder.setType(3);
        builder.setMac("111");
        builder.setSn("qqq");
        builder.setMessageBody("Hello This is Push Message!!!");
        ctx.writeAndFlush(builder);
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        try {
            System.out.println("与服务器失去连接");
            ctx.close();
        }catch (Exception e){
            System.out.println(" 发生异常 关闭 链接时出现异常 ");
        }
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        try {
            System.out.println("正在与服务器断开连接");
            super.channelInactive(ctx);
        }catch(Exception e){
            System.out.println("链接关闭时 发生异常 ");
        }
    }
}
