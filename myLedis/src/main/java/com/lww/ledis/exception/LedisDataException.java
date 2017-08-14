package com.lww.ledis.exception;


/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisDataException extends LedisException {
    private static final long serialVersionUID = 3878126572474819403L;

    public LedisDataException(String message) {
        super(message);
    }

    public LedisDataException(Throwable cause) {
        super(cause);
    }

    public LedisDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
