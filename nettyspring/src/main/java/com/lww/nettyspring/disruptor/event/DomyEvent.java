package com.lww.nettyspring.disruptor.event;
import com.lww.nettyspring.disruptor.executor.DomyExecutor;

/**
 * Created by lenovo on 2017/8/23.
 */
public class DomyEvent extends BaseEvent<DomyExecutor> {
    private DomyExecutor executor;

    public DomyExecutor getExecutor() {
        return executor;
    }

    public void setValues(DomyExecutor executor) {
        this.executor = executor;
    }

    public void clearValues() {
        setValues(null);
    }
}
