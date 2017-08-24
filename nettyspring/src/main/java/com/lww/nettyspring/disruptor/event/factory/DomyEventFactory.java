package com.lww.nettyspring.disruptor.event.factory;

import com.lmax.disruptor.EventFactory;
import com.lww.nettyspring.disruptor.event.DomyEvent;

/**
 * Created by lenovo on 2017/8/23.
 */
public class DomyEventFactory implements EventFactory<DomyEvent> {
    @Override
    public DomyEvent newInstance() {
        return new DomyEvent();
    }
    public static final DomyEventFactory DEFAULT = new DomyEventFactory();

}
