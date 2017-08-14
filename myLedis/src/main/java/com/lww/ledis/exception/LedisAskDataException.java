package com.lww.ledis.exception;

import com.lww.ledis.util.HostAndPort;
import redis.clients.jedis.exceptions.JedisRedirectionException;

/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisAskDataException extends LedisRedirectionException {
    private static final long serialVersionUID = 3878126572474819403L;

    public LedisAskDataException(Throwable cause, HostAndPort targetHost, int slot) {
        super(cause, targetHost, slot);
    }

    public LedisAskDataException(String message, Throwable cause, HostAndPort targetHost, int slot) {
        super(message, cause, targetHost, slot);
    }

    public LedisAskDataException(String message, HostAndPort targetHost, int slot) {
        super(message, targetHost, slot);
    }

}