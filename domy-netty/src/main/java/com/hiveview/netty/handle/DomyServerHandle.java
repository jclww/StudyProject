package com.hiveview.netty.handle;

import com.hiveview.disruptor.event.DomyEvent;
import com.hiveview.disruptor.eventExecutor.BaseExecutor;
import com.hiveview.disruptor.eventExecutor.DomyClientExecutor;
import com.hiveview.disruptor.eventExecutor.DomyForwardExecutor;
import com.hiveview.protobuf.DomyReqMessage;
import com.hiveview.protobuf.DomyResMessage;
import com.lmax.disruptor.RingBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

/**
 * Created by Lww on 2017/8/24.
 */
@ChannelHandler.Sharable
public class DomyServerHandle extends BaseDisruptorAdapterHandler<DomyReqMessage.DomyRequest> {
    @Override
    protected DomyResMessage.DomyResponse.Builder returnMessage() {
        DomyResMessage.DomyResponse.Builder builder = DomyResMessage.DomyResponse.newBuilder();
        builder.setMessage("Welcome to Domy netty !!!");
        return builder;
    }

    @Override
    protected BaseExecutor newExecutor(Channel ch, DomyReqMessage.DomyRequest info) {
        //客户端发送消息
        if (info.getType() == 2) {
            return new DomyClientExecutor(ch, info);
        }
        //服务器发送消息
        if (info.getType() == 3) {
            return new DomyForwardExecutor(ch, info);
        }
        return null;
    }
}
