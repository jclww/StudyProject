package com.netty.spdy;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class SpdyServerInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;

    public SpdyServerInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast(sslCtx.newHandler(ch.alloc()));
        // Negotiates with the browser if SPDY or HTTP is going to be used
        p.addLast(new SpdyOrHttpHandler());
    }
}