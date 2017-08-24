package com.hiveview.disruptor.event.factory;

import com.hiveview.disruptor.event.DomyEvent;
import com.lmax.disruptor.EventFactory;

/**
 * Created by Lww on 2017/8/24.x
 */
public class DomyEventFactory implements EventFactory<DomyEvent> {
    @Override
    public DomyEvent newInstance() {
        return new DomyEvent();
    }
    public static final DomyEventFactory DEFAULT = new DomyEventFactory();

}