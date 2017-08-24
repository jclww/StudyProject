package com.lww.nettyspring.netty.handle;

import com.lww.nettyspring.disruptor.executor.BaseExecutor;
import com.lww.nettyspring.disruptor.executor.DomyExecutor;
import com.lww.nettyspring.disruptor.executor.ForwardExecutor;
import io.netty.channel.Channel;

import java.util.concurrent.Executor;

/**
 * Created by lenovo on 2017/8/23.
 */
public class MessageForwardHandle extends BaseServerDisruptorHandle<Object> {
    @Override
    protected BaseExecutor newExecutor(Channel ch, Object msg) {

        return new ForwardExecutor(ch, msg);
    }
}
