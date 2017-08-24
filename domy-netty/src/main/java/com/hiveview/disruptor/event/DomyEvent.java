package com.hiveview.disruptor.event;

import com.hiveview.disruptor.eventExecutor.BaseExecutor;
import com.hiveview.disruptor.eventExecutor.DomyForwardExecutor;

/**
 * Created by Lww on 2017/8/24.
 *
 * disruptor存放事件
 */
public class DomyEvent {
    private BaseExecutor executor;
    public BaseExecutor getExecutor() {
        return executor;
    }

    public void setValues(BaseExecutor executor) {
        this.executor = executor;
    }
    public void clearValues() {
        setValues(null);
    }
}
