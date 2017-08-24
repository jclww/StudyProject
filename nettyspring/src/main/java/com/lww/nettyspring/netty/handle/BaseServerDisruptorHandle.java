package com.lww.nettyspring.netty.handle;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lww.nettyspring.disruptor.event.BaseEvent;
import com.lww.nettyspring.disruptor.event.DomyEvent;
import com.lww.nettyspring.disruptor.event.ForwardEvent;
import com.lww.nettyspring.disruptor.event.factory.DomyEventFactory;
import com.lww.nettyspring.disruptor.event.factory.ForwardEventFactory;
import com.lww.nettyspring.disruptor.executor.BaseExecutor;
import com.lww.nettyspring.disruptor.handle.DomyHandle;
import com.lww.nettyspring.disruptor.handle.ForwardHandle;
import com.lww.nettyspring.protobuf.DomyReqMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2017/8/23.
 */
public abstract class BaseServerDisruptorHandle<O> extends SimpleChannelInboundHandler<O> {
    //    public static final ConcurrentHashMap<UUID, Session> SESSIONS = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<Channel, UUID> CHANNEL_UUID = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, Channel> MACSNS_CHANNEL = new ConcurrentHashMap<>();

    private static final int DEFAULT_RING_BUFFER_SIZE = 8 * 1024;
    private static final ExecutorService CACHED_THREAD_POOL = Executors.newFixedThreadPool(16);
    private static final ThreadLocal<Disruptor<ForwardEvent>> THREAD_LOCAL = new ThreadLocal<Disruptor<ForwardEvent>>() {
        @Override
        protected Disruptor<ForwardEvent> initialValue() {
            Disruptor<ForwardEvent> disruptor = new Disruptor<>(
                    ForwardEventFactory.DEFAULT, DEFAULT_RING_BUFFER_SIZE, CACHED_THREAD_POOL, ProducerType.SINGLE, new BlockingWaitStrategy());
            disruptor.handleEventsWith(new ForwardHandle());
//            disruptor.handleExceptionsWith();
            disruptor.start();
            return disruptor;
        }
    };

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UUID uuid = UUID.randomUUID();
        CHANNEL_UUID.put(ctx.channel(), uuid);
//        Session session = newSession(ctx.channel());
//        SESSIONS.put(uuid, session);
        super.channelActive(ctx);
        System.out.println("UUID: "+uuid);
    }

//    protected Session newSession(Channel channel) {
//        return new NetSession(channel);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, O msg) throws Exception {

//        DomyReqMessage.DomyRequest info = (DomyReqMessage.DomyRequest)msg;
//        String key  = info.getMac()+info.getSn();
//        MACSNS_CHANNEL.put(key,ctx.channel());

        UUID uuid = CHANNEL_UUID.get(ctx.channel());
//        System.out.println("UUID: "+uuid);
        System.out.println(msg);

        if (null != uuid) {
//            Session session = SESSIONS.get(uuid);
//            if (null != session) {
            RingBuffer<ForwardEvent> ringBuffer = THREAD_LOCAL.get().getRingBuffer();
            long next = ringBuffer.next();
            try {
                BaseEvent commandEvent = ringBuffer.get(next);
                commandEvent.setValues(newExecutor(ctx.channel(), msg));
            } finally {
                ringBuffer.publish(next);
            }
//            }
        }
    }
    protected abstract BaseExecutor newExecutor(Channel ch, O msg);

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        UUID uuid = CHANNEL_UUID.remove(ctx.channel());
//        if (null != uuid) {
//            sessionInactive(SESSIONS.remove(uuid));
//        }
        super.channelInactive(ctx);
    }

}
