package com.lww.ledis.exception;

import com.lww.ledis.util.HostAndPort;
import redis.clients.jedis.exceptions.JedisRedirectionException;

/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisMovedDataException extends LedisRedirectionException {
    private static final long serialVersionUID = 3878126572474819403L;

    public LedisMovedDataException(String message, HostAndPort targetNode, int slot) {
        super(message, targetNode, slot);
    }

    public LedisMovedDataException(Throwable cause, HostAndPort targetNode, int slot) {
        super(cause, targetNode, slot);
    }

    public LedisMovedDataException(String message, Throwable cause, HostAndPort targetNode, int slot) {
        super(message, cause, targetNode, slot);
    }
}