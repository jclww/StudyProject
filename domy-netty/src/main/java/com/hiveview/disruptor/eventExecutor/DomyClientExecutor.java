package com.hiveview.disruptor.eventExecutor;

import com.hiveview.protobuf.DomyReqMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

/**
 * Created by Lww on 2017/8/24.
 */
@Service
public class DomyClientExecutor implements BaseExecutor {
    private Channel ch;
    private DomyReqMessage.DomyRequest info;
    public DomyClientExecutor(Channel ch, DomyReqMessage.DomyRequest info) {
        this.ch = ch;
        this.info = info;
    }

    @Override
    public void onExecute() {

    }

    @Override
    public void release() {

    }
}
