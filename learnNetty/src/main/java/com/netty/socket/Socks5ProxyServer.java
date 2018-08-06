///*
// * Copyright 2014 The Netty Project
// *
// * The Netty Project licenses this file to you under the Apache License,
// * version 2.0 (the "License"); you may not use this file except in compliance
// * with the License. You may obtain a copy of the License at:
// *
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations
// * under the License.
// */
//
//package com.netty.socket;
//
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.LineBasedFrameDecoder;
//import io.netty.handler.codec.socksx.v5.*;
//import io.netty.util.CharsetUtil;
//import io.netty.util.internal.SocketUtils;
//
//import java.net.InetSocketAddress;
//import java.net.SocketAddress;
//
//final class Socks5ProxyServer extends ProxyServer {
//
//    private static final String ENCODER = "encoder";
//    private static final String DECODER = "decoder";
//
//    Socks5ProxyServer(boolean useSsl, TestMode testMode, InetSocketAddress destination) {
//        super(useSsl, testMode, destination);
//    }
//
//    Socks5ProxyServer(
//            boolean useSsl, TestMode testMode, InetSocketAddress destination, String username, String password) {
//        super(useSsl, testMode, destination, username, password);
//    }
//
//    @Override
//    protected void configure(SocketChannel ch) throws Exception {
//        ChannelPipeline p = ch.pipeline();
//        switch (testMode) {
//        case INTERMEDIARY:
//            p.addLast(DECODER, new Socks5InitialRequestDecoder());
//            p.addLast(ENCODER, Socks5ServerEncoder.DEFAULT);
//            p.addLast(new Socks5IntermediaryHandler());
//            break;
//        case TERMINAL:
//            p.addLast(DECODER, new Socks5InitialRequestDecoder());
//            p.addLast(ENCODER, Socks5ServerEncoder.DEFAULT);
//            p.addLast(new Socks5TerminalHandler());
//            break;
//        case UNRESPONSIVE:
//            p.addLast(UnresponsiveHandler.INSTANCE);
//            break;
//        }
//    }
//
//    boolean authenticate(ChannelHandlerContext ctx, Object msg) {
//        if (username == null) {
//            ctx.pipeline().replace(DECODER, DECODER, new Socks5CommandRequestDecoder());
//            ctx.write(new DefaultSocks5InitialResponse(Socks5AuthMethod.NO_AUTH));
//            return true;
//        }
//
//        if (msg instanceof Socks5InitialRequest) {
//            ctx.pipeline().replace(DECODER, DECODER, new Socks5PasswordAuthRequestDecoder());
//            ctx.write(new DefaultSocks5InitialResponse(Socks5AuthMethod.PASSWORD));
//            return false;
//        }
//
//        Socks5PasswordAuthRequest req = (Socks5PasswordAuthRequest) msg;
//        if (req.username().equals(username) && req.password().equals(password)) {
//            ctx.pipeline().replace(DECODER, DECODER, new Socks5CommandRequestDecoder());
//            ctx.write(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.SUCCESS));
//            return true;
//        }
//
//        ctx.pipeline().replace(DECODER, DECODER, new Socks5PasswordAuthRequestDecoder());
//        ctx.write(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.FAILURE));
//        return false;
//    }
//
//    private final class Socks5IntermediaryHandler extends IntermediaryHandler {
//
//        private boolean authenticated;
//        private SocketAddress intermediaryDestination;
//
//        @Override
//        protected boolean handleProxyProtocol(ChannelHandlerContext ctx, Object msg) throws Exception {
//            if (!authenticated) {
//                authenticated = authenticate(ctx, msg);
//                return false;
//            }
//
//            Socks5CommandRequest req = (Socks5CommandRequest) msg;
//            assertThat(req.type(), is(Socks5CommandType.CONNECT));
//
//            Socks5CommandResponse res =
//                    new DefaultSocks5CommandResponse(Socks5CommandStatus.SUCCESS, Socks5AddressType.IPv4);
//            intermediaryDestination = SocketUtils.socketAddress(req.dstAddr(), req.dstPort());
//
//            ctx.write(res);
//
//            ctx.pipeline().remove(ENCODER);
//            ctx.pipeline().remove(DECODER);
//
//            return true;
//        }
//
//        @Override
//        protected SocketAddress intermediaryDestination() {
//            return intermediaryDestination;
//        }
//    }
//
//    private final class Socks5TerminalHandler extends TerminalHandler {
//
//        private boolean authenticated;
//
//        @Override
//        protected boolean handleProxyProtocol(ChannelHandlerContext ctx, Object msg) throws Exception {
//            if (!authenticated) {
//                authenticated = authenticate(ctx, msg);
//                return false;
//            }
//
//            Socks5CommandRequest req = (Socks5CommandRequest) msg;
//            assertThat(req.type(), is(Socks5CommandType.CONNECT));
//
//            ctx.pipeline().addBefore(ctx.name(), "lineDecoder", new LineBasedFrameDecoder(64, false, true));
//
//            Socks5CommandResponse res;
//            boolean sendGreeting = false;
//            if (!req.dstAddr().equals(destination.getHostString()) ||
//                       req.dstPort() != destination.getPort()) {
//                res = new DefaultSocks5CommandResponse(Socks5CommandStatus.FORBIDDEN, Socks5AddressType.IPv4);
//            } else {
//                res = new DefaultSocks5CommandResponse(Socks5CommandStatus.SUCCESS, Socks5AddressType.IPv4);
//                sendGreeting = true;
//            }
//
//            ctx.write(res);
//
//            ctx.pipeline().remove(ENCODER);
//            ctx.pipeline().remove(DECODER);
//
//            if (sendGreeting) {
//                ctx.write(Unpooled.copiedBuffer("0\n", CharsetUtil.US_ASCII));
//            }
//
//            return true;
//        }
//    }
//}
