package com.lww.nettyspring.disruptor.executor;

/**
 * Created by lenovo on 2017/8/23.
 */
public interface BaseExecutor {
    void onExecute() throws Exception;
    void release();

}
