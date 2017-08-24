package com.hiveview.disruptor.eventHandle;

import com.hiveview.disruptor.event.DomyEvent;
import com.hiveview.disruptor.eventExecutor.BaseExecutor;
import com.lmax.disruptor.EventHandler;

/**
 * Created by Lww on 2017/8/24.
 *
 * 具体业务调用Execute执行
 */
public class DomyHandle implements EventHandler<DomyEvent> {
    @Override
    public void onEvent(DomyEvent event, long sequence, boolean endOfBatch) throws Exception {
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