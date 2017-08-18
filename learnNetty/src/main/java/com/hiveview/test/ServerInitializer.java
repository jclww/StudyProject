package com.hiveview.test;

import com.lww.netty.simple.WorldClockProtocol;
import com.lww.netty.simple.WorldClockServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by lenovo on 2017/8/17.
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        //处理Tcp发送半包问题
        p.addLast(new ProtobufVarint32FrameDecoder());
        //负责解码
        p.addLast(new ProtobufDecoder(WorldClockProtocol.Locations.getDefaultInstance()));
        //处理Tcp
        p.addLast(new ProtobufVarint32LengthFieldPrepender());
        p.addLast(new ProtobufEncoder());
        p.addLast(new ServerHandler());
    }
}
