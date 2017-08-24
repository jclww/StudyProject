package com.lww.nettyspring.disruptor.event.factory;

import com.lmax.disruptor.EventFactory;
import com.lww.nettyspring.disruptor.event.DomyEvent;
import com.lww.nettyspring.disruptor.event.ForwardEvent;

/**
 * Created by lenovo on 2017/8/23.
 */
public class ForwardEventFactory implements EventFactory<ForwardEvent> {
    @Override
    public ForwardEvent newInstance() {
        return new ForwardEvent();
    }
    public static final ForwardEventFactory DEFAULT = new ForwardEventFactory();

}