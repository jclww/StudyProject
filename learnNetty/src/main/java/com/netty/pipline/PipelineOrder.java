package com.netty.pipline;

import com.netty.proxy.PortUnificationServerHandler;
import com.netty.proxy2.HexDumpProxyBackendHandler;
import com.netty.spdy.SpdyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

public class PipelineOrder {
    static final int PORT = Integer.parseInt(System.getProperty("port", "8086"));


    public static void main(String[] args) throws Exception {
        // Configure SSL context
        SelfSignedCertificate ssc = new SelfSignedCertificate();
        final SslContext sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey())
                .build();

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("ssl",new PortUnificationServerHandler(sslCtx));
                            ch.pipeline().addLast(new SpdyServerHandler() ,new SpdyServerHandler() ,new SpdyServerHandler() );
                            ch.pipeline().addFirst("111",new SpdyServerHandler() );

                            ch.pipeline().addAfter("111", "222", new SpdyServerHandler());
                            ch.pipeline().addAfter("222", "333",new SpdyServerHandler());
                            ch.pipeline().addFirst("555",new SpdyServerHandler() );
                            ch.pipeline().addLast("666",new SpdyServerHandler() );

                        }
                    });

            // Bind and start to accept incoming connections.
            b.bind(PORT).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
