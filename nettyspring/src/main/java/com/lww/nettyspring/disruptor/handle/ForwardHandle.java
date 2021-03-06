package com.lww.nettyspring.disruptor.handle;

import com.lmax.disruptor.EventHandler;
import com.lww.nettyspring.disruptor.event.DomyEvent;
import com.lww.nettyspring.disruptor.event.ForwardEvent;
import com.lww.nettyspring.disruptor.executor.BaseExecutor;

/**
 * Created by lenovo on 2017/8/23.
 */
public class ForwardHandle implements EventHandler<ForwardEvent> {
    @Override
    public void onEvent(ForwardEvent event, long sequence, boolean endOfBatch) throws Exception {
        try {
            BaseExecutor executor = event.getExecutor();
            if (null != executor) {
                try {
                    executor.onExecute();
                } finally {
                    executor.release();
                }
            }
        } finally {
            event.clearValues();
        }
    }
}