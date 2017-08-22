package com.lww.nettyspring.handle;

import com.lww.nettyspring.protobuf.DomyReqMessage;
import com.lww.nettyspring.protobuf.DomyResMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * Created by lenovo on 2017/8/21.
 */
public class DomyServerHandler extends SimpleChannelInboundHandler {

    @Override
    public void channelActive(ChannelHandlerContext ctx)  {
        try {
            System.out.println("客户端已连接");
        }catch (Exception e){
            System.out.println("已连接 发送消息发生故障 "+e.toString());
        }
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        DomyReqMessage.DomyRequest req = (DomyReqMessage.DomyRequest) o;

            System.out.println("Service accept client subscribe req : ["
                    + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getMac()));
    }

    private DomyResMessage.DomyResponse resp(String mac) {
        DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse
                .newBuilder();
        builder.setSn("123");
        builder.setMac(mac);
        builder.setMessageBody("Netty book order succeed, 3 days later, sent to the designated address");
        return builder.build();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        try {
            System.out.println("与客户端失去连接");
            ctx.close();
        }catch (Exception e){
            System.out.println(" 发生异常 关闭 链接时出现异常 ");
        }
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        try {
            System.out.println("正在与客户端断开连接");
            super.channelInactive(ctx);
        }catch(Exception e){
            System.out.println("链接关闭时 发生异常 ");
        }
    }
}
