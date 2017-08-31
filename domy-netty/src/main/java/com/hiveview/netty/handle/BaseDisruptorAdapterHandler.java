package com.hiveview.netty.handle;

import com.hiveview.disruptor.event.DomyEvent;
import com.hiveview.disruptor.event.factory.DomyEventFactory;
import com.hiveview.disruptor.eventExecutor.BaseExecutor;
import com.hiveview.disruptor.eventHandle.DomyHandle;
import com.hiveview.protobuf.DomyReqMessage;
import com.hiveview.protobuf.DomyResMessage;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2017/8/23.
 */
public abstract class BaseDisruptorAdapterHandler<O> extends SimpleChannelInboundHandler<O> {
    /**
     * MACSNS_CHANNEL  key: Mac+sc(String)      values: Channel
     * CHANNEL_MACSNS  key: channelID(String)   values: Mac+sn (String)
     */
    public static final ConcurrentHashMap<String, Channel> MACSNS_CHANNEL = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, String>  CHANNEL_MACSNS = new ConcurrentHashMap<>();

    private static final int DEFAULT_RING_BUFFER_SIZE = 8 * 1024;
    //定长线程池  可以修改为newCachedThreadPool();
    private static final ExecutorService CACHED_THREAD_POOL = Executors.newFixedThreadPool(16);
    private static final ThreadLocal<Disruptor<DomyEvent>> THREAD_LOCAL = new ThreadLocal<Disruptor<DomyEvent>>() {
        @Override
        protected Disruptor<DomyEvent> initialValue() {
            Disruptor<DomyEvent> disruptor = new Disruptor<>(
                    DomyEventFactory.DEFAULT, DEFAULT_RING_BUFFER_SIZE, CACHED_THREAD_POOL, ProducerType.SINGLE, new BlockingWaitStrategy());
            disruptor.handleEventsWith(new DomyHandle());
            disruptor.start();
            return disruptor;
        }
    };

    /**
     * 连接建立调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 处理各类请求(1、登录 2、客户端发送的消息 3、大麦service消息)
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, O msg) throws Exception {
        DomyReqMessage.DomyRequest info = (DomyReqMessage.DomyRequest)msg;
        //登录消息
        if (info.getType() == 1) {
            doLoginMessage(ctx,msg);
        }
        //客户端请求
        if (info.getType() == 2) {
            doClientMessage();
        }
        //大麦Services发送的消息(推送)
        if (info.getType() == 3) {
            doDomyServiceSendMessage(ctx, msg);
        }
    }

    private void doLoginMessage(ChannelHandlerContext ctx, O msg) {
        DomyReqMessage.DomyRequest info = (DomyReqMessage.DomyRequest)msg;
        String key = info.getMac()+info.getSn();
        MACSNS_CHANNEL.put(key, ctx.channel());
        CHANNEL_MACSNS.put(ctx.channel().id().asLongText(), key);
        DomyResMessage.DomyResponse.Builder returnMessage = returnMessage();
        ctx.writeAndFlush(returnMessage);
//        ctx.fireChannelRead(msg);
    }

    private void doClientMessage() {
        //未做
    }

    private void doDomyServiceSendMessage(ChannelHandlerContext ctx, O msg) {
        RingBuffer<DomyEvent> ringBuffer = THREAD_LOCAL.get().getRingBuffer();
        long next = ringBuffer.next();
        try {
            DomyEvent commandEvent = ringBuffer.get(next);
            commandEvent.setValues(newExecutor(ctx.channel(), msg));
        } finally {
            ringBuffer.publish(next);
        }
    }

    protected abstract DomyResMessage.DomyResponse.Builder returnMessage();

    protected abstract BaseExecutor newExecutor(Channel ch, O msg);

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String mac_sn = CHANNEL_MACSNS.get(ctx.channel().id().asLongText());
        //判断是否存在key
        if (StringUtils.isEmpty(mac_sn) && (MACSNS_CHANNEL.get(mac_sn) == null)) {
            System.out.println("连接已经关闭");
            return;
        }
        //删除数据
        MACSNS_CHANNEL.remove(mac_sn);
        CHANNEL_MACSNS.remove(ctx.channel().id().asLongText());

        System.out.println("正在与mac_sn: " + mac_sn + "断开连接");
        ctx.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
            System.out.println("客户端强制断开连接");
            ctx.close();
        }catch (Exception e){
            System.out.println("发生异常关闭链接时出现异常");
        }
    }
}
