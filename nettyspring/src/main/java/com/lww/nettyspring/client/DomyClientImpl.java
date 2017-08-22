package com.lww.nettyspring.client;

import com.lww.nettyspring.handle.DomyClientHandle;
import com.lww.nettyspring.protobuf.DomyResMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by lenovo on 2017/8/21.
 */
public class DomyClientImpl implements DomyClient {
    private EventLoopGroup group;
    private Bootstrap b;
    private DomyClientHandle domyClientHandle;
    private String host;
    private int port;

    @Override
    public void start() {
        // 配置客户端NIO线程组
//        EventLoopGroup group = new NioEventLoopGroup();
        try {
//            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(
                                    new ProtobufVarint32FrameDecoder());
                            ch.pipeline().addLast(
                                    new ProtobufDecoder(
                                            DomyResMessage.DomyResponse
                                                    .getDefaultInstance()));
                            ch.pipeline().addLast(
                                    new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            ch.pipeline().addLast(domyClientHandle);
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = null;
                f = b.connect(host, port).sync();

                // 当代客户端链路关闭
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 优雅退出，释放NIO线程组
                group.shutdownGracefully();
            }
    }

    public EventLoopGroup getGroup() {
        return group;
    }

    public void setGroup(EventLoopGroup group) {
        this.group = group;
    }

    public Bootstrap getB() {
        return b;
    }

    public void setB(Bootstrap b) {
        this.b = b;
    }

    public DomyClientHandle getDomyClientHandle() {
        return domyClientHandle;
    }

    public void setDomyClientHandle(DomyClientHandle domyClientHandle) {
        this.domyClientHandle = domyClientHandle;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
