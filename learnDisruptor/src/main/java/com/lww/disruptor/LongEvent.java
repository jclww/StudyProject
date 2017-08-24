package com.lww.disruptor;

/**
 * Created by lenovo on 2017/8/22.
 */
public class LongEvent
{
    private long value;

    public void set(long value)
    {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
