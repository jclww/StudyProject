package com.lww.ledis.exception;


/**
 * Created by Lww on 2017/7/26.
 */
public class LedisConnectionException extends LedisException {
    private static final long serialVersionUID = 3878126572474819403L;

    public LedisConnectionException(String message) {
        super(message);
    }

    public LedisConnectionException(Throwable cause) {
        super(cause);
    }

    public LedisConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}