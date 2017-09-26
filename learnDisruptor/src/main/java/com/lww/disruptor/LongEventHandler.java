package com.lww.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by lenovo on 2017/8/22.
 */
public class LongEventHandler implements EventHandler<LongEvent>
{
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws InterruptedException {
    Thread.sleep(3000);
    System.out.println("Event: " + event.getValue()+"sequence: "+sequence+"endOfBatch: "+endOfBatch);
}
}