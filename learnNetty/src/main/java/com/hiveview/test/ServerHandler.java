package com.hiveview.test;

import com.lww.netty.simple.WorldClockProtocol;
import com.lww.netty.simple.WorldClockProtocol.Locations;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by lenovo on 2017/8/17.
 */
public class ServerHandler extends SimpleChannelInboundHandler<Locations> {

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Locations locations) throws Exception {




    }
}
