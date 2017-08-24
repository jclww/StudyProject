package com.lww.nettyspring.test;

import com.lww.nettyspring.netty.handle.MessageForwardHandle;
import com.lww.nettyspring.netty.handle.TestDisruptorHandle;
import com.lww.nettyspring.protobuf.DomyReqMessage;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;

/**
 * Created by lenovo on 2017/8/23.
 */
public class DisruptorServer {
    private static final ChannelHandler HANDLER = new MessageForwardHandle();

    private Channel acceptorChannel;
    public void start() {
//        System.out.println("hello");
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        EventExecutor e1 = new DefaultEventExecutor();
        try{
            //辅助启动类
            ServerBootstrap b =new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(
                                    new ProtobufVarint32FrameDecoder());
                            ch.pipeline().addLast(
                                    new ProtobufDecoder(
                                            DomyReqMessage.DomyRequest.getDefaultInstance()));
                            ch.pipeline().addLast(
                                    new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            ch.pipeline().addLast("handler", HANDLER);
//                            ch.pipeline().addLast(new DomyDBHadle());

                        }
                    });
            //绑定端口 同步等待成功
            ChannelFuture f=b.bind(6666).sync();  //阻塞绑定监听端口  返回操作通知类
            System.out.println("绑定端口 等待客户端长连接");
            //等待服务端监听端口关闭
            acceptorChannel = f.channel();
            acceptorChannel.closeFuture().sync();     //等待服务端链路关闭之后 才推出main函数
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] a) {
        new DisruptorServer().start();
    }

}
