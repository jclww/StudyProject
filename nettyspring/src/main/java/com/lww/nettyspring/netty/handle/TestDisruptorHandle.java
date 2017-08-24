package com.lww.nettyspring.netty.handle;

import com.lww.nettyspring.disruptor.executor.BaseExecutor;
import com.lww.nettyspring.disruptor.executor.DomyExecutor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

/**
 * Created by lenovo on 2017/8/23.
 */
//@ChannelHandler.Sharable
public class TestDisruptorHandle extends BaseDisruptorAdapterHandler<Object> {
    @Override
    protected BaseExecutor newExecutor(Channel ch, Object msg) {

        return new DomyExecutor(ch, msg);
    }
}
