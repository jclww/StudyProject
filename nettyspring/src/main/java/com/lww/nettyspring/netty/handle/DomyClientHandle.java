package com.lww.nettyspring.netty.handle;

import com.lww.nettyspring.protobuf.DomyReqMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * Created by lenovo on 2017/8/21.
 */
public class DomyClientHandle extends SimpleChannelInboundHandler {

    public void channelActive(ChannelHandlerContext ctx) {
        ctx.write(subReq(1));
        ctx.flush();
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        System.out.println("Receive server response : [" + o + "]");
//        ctx.close();
    }
    private DomyReqMessage.DomyRequest subReq(int i) {
        DomyReqMessage.DomyRequest.Builder builder = DomyReqMessage.DomyRequest
                .newBuilder();
        builder.setMac("123");
        builder.setSn("qwqw");
        builder.setType(i);
        return builder.build();
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
