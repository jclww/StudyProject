package com.hiveview.netty.server;

import com.hiveview.netty.handle.DomyServerHandle;
import com.hiveview.protobuf.DomyReqMessage;
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
 * Created by Lww on 2017/8/24.
 */
public class DomyDisruptorServer implements DomyServer{
    private static final ChannelHandler FPROTOBUF_PREPENDER = new ProtobufVarint32LengthFieldPrepender();
    private static final ChannelHandler PROTOBUF_DECODER = new ProtobufVarint32FrameDecoder();
    private static final ChannelHandler PROTOBUF_ENCODER = new ProtobufEncoder();
    private static final ChannelHandler SERVER_HANDLER = new DomyServerHandle();
    @Override
    public void start() {
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
                            ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            ch.pipeline().addLast(
                                    new ProtobufDecoder(DomyReqMessage.DomyRequest.getDefaultInstance()));
                            ch.pipeline().addLast(FPROTOBUF_PREPENDER);
                            ch.pipeline().addLast(PROTOBUF_ENCODER);
                            ch.pipeline().addLast(SERVER_HANDLER);
//                            ch.pipeline().addLast(new DomyDBHadle());

                        }
                    });
            //绑定端口 同步等待成功
            ChannelFuture f=b.bind(8888).sync();  //阻塞绑定监听端口  返回操作通知类
            System.out.println("绑定端口 等待客户端长连接");
            //等待服务端监听端口关闭
//            acceptorChannel = f.channel();
            f.channel().closeFuture().sync();     //等待服务端链路关闭之后 退出main函数
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] a) {
        new DomyDisruptorServer().start();
    }
}
