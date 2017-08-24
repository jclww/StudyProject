package com.lww.nettyspring.disruptor.event;

import com.lww.nettyspring.disruptor.executor.DomyExecutor;
import com.lww.nettyspring.disruptor.executor.ForwardExecutor;

/**
 * Created by lenovo on 2017/8/23.
 */
public class ForwardEvent extends BaseEvent<ForwardExecutor> {
    private ForwardExecutor executor;

    public ForwardExecutor getExecutor() {
        return executor;
    }

    public void setValues(ForwardExecutor executor) {
        this.executor = executor;
    }

    public void clearValues() {
        setValues(null);
    }
}
