package com.lww.ledis;

import com.lww.ledis.commands.StringCommands;

import java.util.List;

/**
 * Created by lenovo on 2017/7/27.
 */
public class Ledis extends BinaryLedis implements StringCommands{
    public Ledis(final String host, final int port) {
        super(host, port);
    }

    /**
     * String
     */
    public Long append(final String key, final String value) {
        checkIsInMultiOrPipeline();
        client.append(key, value);
        return client.getIntegerReply();
    }

    public Long decrBy(final String key, final long integer) {
        checkIsInMultiOrPipeline();
        client.decrBy(key, integer);
        return client.getIntegerReply();
    }

    public Long decr(final String key) {
        checkIsInMultiOrPipeline();
        client.decr(key);
        return client.getIntegerReply();
    }

    public String get(final String key) {
        checkIsInMultiOrPipeline();
        client.get(key);
        return client.getBulkReply();
    }

    public String getrange(String key, long startOffset, long endOffset) {
        client.getrange(key, startOffset, endOffset);
        return client.getBulkReply();
    }

    public String getSet(final String key, final String value) {
        checkIsInMultiOrPipeline();
        client.getSet(key, value);
        return client.getBulkReply();
    }

    public Long incrBy(final String key, final long integer) {
        checkIsInMultiOrPipeline();
        client.incrBy(key, integer);
        return client.getIntegerReply();
    }

    public Double incrByFloat(final String key, final double value) {
        checkIsInMultiOrPipeline();
        client.incrByFloat(key, value);
        String dval = client.getBulkReply();
        return (dval != null ? new Double(dval) : null);
    }

    public Long incr(final String key) {
        checkIsInMultiOrPipeline();
        client.incr(key);
        return client.getIntegerReply();
    }

    public List<String> mget(final String... keys) {
        checkIsInMultiOrPipeline();
        client.mget(keys);
        return client.getMultiBulkReply();
    }

    public String mset(final String... keysvalues) {
        checkIsInMultiOrPipeline();
        client.mset(keysvalues);
        return client.getStatusCodeReply();
    }

    public Long msetnx(final String... keysvalues) {
        checkIsInMultiOrPipeline();
        client.msetnx(keysvalues);
        return client.getIntegerReply();
    }

    public String set(final String key, String value) {

        client.set(key, value);
        return client.getStatusCodeReply();
    }

    public String setex(final String key, final int seconds, final String value) {
        checkIsInMultiOrPipeline();
        client.setex(key, seconds, value);
        return client.getStatusCodeReply();
    }

    public Long setnx(final String key, final String value) {
        checkIsInMultiOrPipeline();
        client.setnx(key, value);
        return client.getIntegerReply();
    }

    public Long setrange(String key, long offset, String value) {
        client.setrange(key, offset, value);
        return client.getIntegerReply();
    }

    public Long strlen(final String key) {
        client.strlen(key);
        return client.getIntegerReply();
    }
}
