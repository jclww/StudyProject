package com.lww.nettyspring.server;

import com.lww.nettyspring.handle.DomyDBHadle;
import com.lww.nettyspring.handle.DomyServerHandler;
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
 * Created by lenovo on 2017/8/21.
 */

public class DomyServerImpl implements DomyServer {
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap b;
    private int port;
    private Channel acceptorChannel;
    public void start() {
//        System.out.println("hello");
//        EventLoopGroup bossGroup=new NioEventLoopGroup();
//        EventLoopGroup workerGroup=new NioEventLoopGroup();
        EventExecutor e1 = new DefaultEventExecutor();
        try{
            //辅助启动类
//            ServerBootstrap b =new ServerBootstrap();
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
                            ch.pipeline().addLast(e1,"DBHandle",new DomyDBHadle());
                            ch.pipeline().addLast(new DomyServerHandler());
                        }
                    });
            //绑定端口 同步等待成功
            ChannelFuture f=b.bind(port).sync();  //阻塞绑定监听端口  返回操作通知类
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
    public void stop()throws  Exception {
        try{
            if(acceptorChannel!=null)
                acceptorChannel.close().addListener(ChannelFutureListener.CLOSE);
        }finally{
            //优雅退出，释放线程组资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public EventLoopGroup getBossGroup() {
        return bossGroup;
    }

    public void setBossGroup(EventLoopGroup bossGroup) {
        this.bossGroup = bossGroup;
    }

    public EventLoopGroup getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(EventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public ServerBootstrap getB() {
        return b;
    }

    public void setB(ServerBootstrap b) {
        this.b = b;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
