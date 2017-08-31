package com.hiveview.netty.client;

import com.hiveview.protobuf.DomyReqMessage;
import com.hiveview.protobuf.DomyResMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by Lww on 2017/8/24.
 */
public class DomyClient1 implements DomyClient {
    private int port;
    private Channel ch;

    public DomyClient1(int port) {
        this.port = port;
    }

    @Override
    public void start() {
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
                                    builder.setType(1);
                                    builder.setMac("111");
                                    builder.setSn("qqq");
//                                    builder.setMessageBody("Hello This is Push Message!!!");
                                    ctx.writeAndFlush(builder);
                                }
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
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
            f = b.connect("localhost", port).sync();
            ch = f.channel();
            // 当代客户端链路关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }
    public void sendMessage(DomyReqMessage.DomyRequest.Builder req) {
        if (ch == null && ch.isActive()) {
            ch.writeAndFlush(req);
        }
        else {
            System.out.println("您与服务器已经断开连接！！");
        }
    }
//    public static void main(String[] a) {
//        new DomyClient1().start();
//    }
}
