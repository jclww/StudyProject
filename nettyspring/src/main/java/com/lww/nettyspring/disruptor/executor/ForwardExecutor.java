package com.lww.nettyspring.disruptor.executor;

import com.lww.nettyspring.netty.handle.BaseDisruptorAdapterHandler;
import com.lww.nettyspring.netty.handle.TestDisruptorHandle;
import com.lww.nettyspring.protobuf.DomyReqMessage;
import io.netty.channel.Channel;

/**
 * Created by lenovo on 2017/8/23.
 */
public class ForwardExecutor implements BaseExecutor {
    private Channel ch;
    private Object msg;

    public ForwardExecutor(Channel ch, Object msg) {
//        this.ch = ch;
        this.msg = msg;

    }

    public void onExecute() throws Exception {
        DomyReqMessage.DomyRequest info = (DomyReqMessage.DomyRequest)msg;
//        String mac = info.getMac();
//        String sn = info.getSn();
        String key = info.getMac()+info.getSn();
        this.ch = BaseDisruptorAdapterHandler.MACSNS_CHANNEL.get(key);
        System.out.println("MACSNS_CHANNEL: "+ TestDisruptorHandle.MACSNS_CHANNEL.size());

        System.out.println("key: "+key);
        if (null == msg) {
            throw new NullPointerException("msg");
        }
        ch.writeAndFlush(msg);
    }
    public void release() {
        this.ch = null;
        this.msg = null;
    }
}