package com.lww.ledis;

import com.lww.ledis.client.Client;
import com.lww.ledis.commands.BinaryStringCommands;
import com.lww.ledis.commands.ConnectionCommands;
import com.lww.ledis.commands.RedisInfoCommands;

import java.util.List;

/**
 * Created by lenovo on 2017/7/27.
 */
public class BinaryLedis implements ConnectionCommands,BinaryStringCommands,RedisInfoCommands{
    protected Client client = null;

    public String quit() {
        checkIsInMultiOrPipeline();
        client.quit();
        return client.getStatusCodeReply();
    }

    public BinaryLedis(final String host, final int port) {
        client = new Client(host, port);
    }
    public String ping() {
        checkIsInMultiOrPipeline();
        client.ping();
        return client.getStatusCodeReply();
    }
    public String auth(final String password) {
        checkIsInMultiOrPipeline();
        client.auth(password);
        return client.getStatusCodeReply();
    }







//    protected void checkIsInMultiOrPipeline() {
//        if (client.isInMulti()) {
//            throw new LedisDataException(
//                    "Cannot use Jedis when in Multi. Please use Transation or reset jedis state.");
//        } else if (pipeline != null && pipeline.hasPipelinedResponse()) {
//            throw new LedisDataException(
//                    "Cannot use Jedis when in Pipeline. Please use Pipeline or reset jedis state .");
//        }
//    }

    protected void checkIsInMultiOrPipeline() {

    }

    /**
     * BinaryStringCommands
     */

    public Long append(final byte[] key, final byte[] value) {
        checkIsInMultiOrPipeline();
        client.append(key, value);
        return client.getIntegerReply();
    }

    public Long decrBy(final byte[] key, final long integer) {
        checkIsInMultiOrPipeline();
        client.decrBy(key, integer);
        return client.getIntegerReply();
    }

    public Long decr(final byte[] key) {
        checkIsInMultiOrPipeline();
        client.decr(key);
        return client.getIntegerReply();
    }

    public byte[] get(final byte[] key) {
        checkIsInMultiOrPipeline();
        client.get(key);
        return client.getBinaryBulkReply();
    }

    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        client.getrange(key, startOffset, endOffset);
        return client.getBinaryBulkReply();
    }

    public byte[] getSet(final byte[] key, final byte[] value) {
        checkIsInMultiOrPipeline();
        client.getSet(key, value);
        return client.getBinaryBulkReply();
    }

    public Long incrBy(final byte[] key, final long integer) {
        checkIsInMultiOrPipeline();
        client.incrBy(key, integer);
        return client.getIntegerReply();
    }

    public Double incrByFloat(final byte[] key, final double integer) {
        checkIsInMultiOrPipeline();
        client.incrByFloat(key, integer);
        String dval = client.getBulkReply();
        return (dval != null ? new Double(dval) : null);
    }

    public Long incr(final byte[] key) {
        checkIsInMultiOrPipeline();
        client.incr(key);
        return client.getIntegerReply();
    }

    public List<byte[]> mget(final byte[]... keys) {
        checkIsInMultiOrPipeline();
        client.mget(keys);
        return client.getBinaryMultiBulkReply();
    }

    public String mset(final byte[]... keysvalues) {
        checkIsInMultiOrPipeline();
        client.mset(keysvalues);
        return client.getStatusCodeReply();
    }

    public Long msetnx(final byte[]... keysvalues) {
        checkIsInMultiOrPipeline();
        client.msetnx(keysvalues);
        return client.getIntegerReply();
    }

    public String set(final byte[] key, final byte[] value) {
        checkIsInMultiOrPipeline();
        client.set(key, value);
        return client.getStatusCodeReply();
    }

    public String setex(final byte[] key, final int seconds, final byte[] value) {
        checkIsInMultiOrPipeline();
        client.setex(key, seconds, value);
        return client.getStatusCodeReply();
    }

    public Long setnx(final byte[] key, final byte[] value) {
        checkIsInMultiOrPipeline();
        client.setnx(key, value);
        return client.getIntegerReply();
    }

    public Long setrange(byte[] key, long offset, byte[] value) {
        client.setrange(key, offset, value);
        return client.getIntegerReply();
    }

    public Long strlen(final byte[] key) {
        client.strlen(key);
        return client.getIntegerReply();
    }

    /**
     * Hash(哈希表)
     */

    /**
     * RedisInfoCommands
     */

    public String getRedisRole() {
        return ";";

    }

    public void getRedisInfo(String... keys) {

    }

    public String info() {
        client.info();
        return client.getBulkReply();
    }

}
