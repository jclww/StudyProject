package com.hiveview.disruptor.eventExecutor;

/**
 * Created by Lww on 2017/8/24.
 *
 * 具体业务处理类
 */
public interface BaseExecutor {
    void onExecute();
    void release();
}
