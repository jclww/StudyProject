package com.lww.nettyspring.test;

import com.lww.nettyspring.protobuf.DomyReqMessage;
import com.lww.nettyspring.protobuf.DomyResMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lenovo on 2017/8/23.
 */
public class ClientTest {
    public static final AtomicInteger COUNT = new AtomicInteger(0);

    private static final ChannelHandler FRAME_PREPENDER = new LengthFieldPrepender(2, false);
    private static final ChannelHandler STRING_DECODER = new StringDecoder();
    private static final ChannelHandler STRING_ENCODER = new StringEncoder();
//    @Override
    public void start() {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
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
                            ch.pipeline().addLast("handler", new SimpleChannelInboundHandler<Object>() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    DomyReqMessage.DomyRequest.Builder builder = DomyReqMessage.DomyRequest
                                            .newBuilder();
                                    builder.setMac("125");
                                    builder.setSn("qwqw");
                                    builder.setType(1);
                                    ctx.writeAndFlush(builder);
                                }
                                    @Override
                                protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    COUNT.getAndIncrement();
                                        System.out.println(msg);
//                        ChannelPromise voidPromise = ctx.voidPromise();
//                        if (ctx.channel().isWritable()) {
//                            ctx.writeAndFlush(msg, voidPromise);
//                        } else {
//                            ctx.channel().eventLoop().schedule(() -> {
//                                ctx.writeAndFlush(msg, voidPromise);
//                            }, 1L, TimeUnit.SECONDS);
//                        }
                                }
                            });
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = null;
            f = b.connect("localhost", 8888).sync();

            // 当代客户端链路关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }
    public static void main(String[] a) {
        new ClientTest().start();
    }
}
