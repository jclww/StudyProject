package com.lww.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by lenovo on 2017/8/22.
 */

public class LongEventFactory implements EventFactory<LongEvent>
{
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}
