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
    private Channel channel;
    private Channel clientChannel;
    private DomyReqMessage.DomyRequest info;
    public DomyForwardExecutor(Channel ch, DomyReqMessage.DomyRequest info) {
        this.channel = ch;
        this.info = info;
    }

    @Override
    public void onExecute() {
        if (info == null)
            return ;
        this.clientChannel = getClientChannelByKey();
        System.out.println("MACSNS_CHANNEL: "+ BaseDisruptorAdapterHandler.MACSNS_CHANNEL.size());

        if (clientChannel != null && clientChannel.isActive()) {
            DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
            //直接将服务器推送消息传递给Client
            builder.setMessage(info.getMessageBody());
            clientChannel.writeAndFlush(builder);
        } else {
            DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
            //Client下线或者不存在时返回消息给Service
            builder.setMessage(info.getMessageBody());
            channel.writeAndFlush(builder);
        }

    }

    private Channel getClientChannelByKey() {
        String key = info.getMac()+info.getSn();
        return BaseDisruptorAdapterHandler.MACSNS_CHANNEL.get(key);
    }

    protected DomyResMessage.DomyResponse.Builder successMessage() {
        DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
        //直接将服务器推送消息传递给Client
        builder.setMessage(info.getMessageBody());
        return builder;
    }

    protected DomyResMessage.DomyResponse.Builder errorMessage() {
        DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
        builder.setMessage("Welcome to Domy netty !!!");
        return builder;
    }

    @Override
    public void release() {
        this.channel = null;
        this.clientChannel = null;
        this.info = null;
    }
}
