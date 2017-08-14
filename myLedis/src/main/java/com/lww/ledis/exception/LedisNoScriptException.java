package com.lww.ledis.exception;


/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisNoScriptException extends LedisDataException {
    private static final long serialVersionUID = 4674378093072060731L;

    public LedisNoScriptException(final String message) { super(message); }

    public LedisNoScriptException(final Throwable cause) { super(cause); }

    public LedisNoScriptException(final String message, final Throwable cause) { super(message, cause); }
}
