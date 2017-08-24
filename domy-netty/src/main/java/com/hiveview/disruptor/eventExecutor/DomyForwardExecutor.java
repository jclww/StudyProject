package com.hiveview.disruptor.eventExecutor;

import com.hiveview.netty.handle.BaseDisruptorAdapterHandler;
import com.hiveview.protobuf.DomyReqMessage;
import com.hiveview.protobuf.DomyResMessage;
import io.netty.channel.Channel;

/**
 * Created by Lww on 2017/8/24.
 *
 * 处理Server发送的数据并转发给对应的Client
 */

public class DomyForwardExecutor implements BaseExecutor {
    private Channel ch;
    private DomyReqMessage.DomyRequest info;
    public DomyForwardExecutor(Channel ch, DomyReqMessage.DomyRequest info) {
        this.ch = ch;
        this.info = info;
    }

    @Override
    public void onExecute() {
        String key = info.getMac()+info.getSn();
        this.ch = BaseDisruptorAdapterHandler.MACSNS_CHANNEL.get(key);
        System.out.println("MACSNS_CHANNEL: "+ BaseDisruptorAdapterHandler.MACSNS_CHANNEL.size());

//        System.out.println("key: "+key);
        if (null == info) {
            throw new NullPointerException("msg");
        }
        DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
        builder.setMessage(info.getMessageBody());
        ch.writeAndFlush(builder);
    }

    @Override
    public void release() {
        this.ch = null;
        this.info = null;
    }
}
