package com.lww.nettyspring.disruptor.event;


/**
 * Created by lenovo on 2017/8/23.
 */
public class BaseEvent<T> {
    private T executor;
    public T getExecutor() {
        return executor;
    }

    public void setValues(T executor) {
        this.executor = executor;
    }
    public void clearValues() {
        setValues(null);
    }
}
