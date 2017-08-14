package com.lww.ledis.exception;

import com.lww.ledis.util.HostAndPort;

/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisRedirectionException extends LedisDataException {
    private static final long serialVersionUID = 3878126572474819403L;

    private HostAndPort targetNode;
    private int slot;

    public LedisRedirectionException(String message, HostAndPort targetNode, int slot) {
        super(message);
        this.targetNode = targetNode;
        this.slot = slot;
    }

    public LedisRedirectionException(Throwable cause, HostAndPort targetNode, int slot) {
        super(cause);
        this.targetNode = targetNode;
        this.slot = slot;
    }

    public LedisRedirectionException(String message, Throwable cause, HostAndPort targetNode, int slot) {
        super(message, cause);
        this.targetNode = targetNode;
        this.slot = slot;
    }

    public HostAndPort getTargetNode() {
        return targetNode;
    }

    public int getSlot() {
        return slot;
    }
}
