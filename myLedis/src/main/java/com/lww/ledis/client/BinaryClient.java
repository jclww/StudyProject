package com.lww.ledis.client;

import com.lww.ledis.connection.Connection;
import com.lww.ledis.global.GlobalCommand;
import com.lww.ledis.global.GlobalPosition;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.SortingParams;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static com.lww.ledis.protocol.RedisProtocol.toByteArray;


/**
 * Created by Lww on 2017/7/27.
 */
public class BinaryClient extends Connection {
    private String password;
    private long db  = 0;

    private boolean isInWatch;
    private boolean isInMulti;

    public BinaryClient() {
        super();
    }
    public BinaryClient(final String host) {
        super(host);
    }

    public BinaryClient(final String host, final int port) {
        super(host, port);
    }

    public BinaryClient(final String host, final int port, final boolean ssl) {
        super(host, port, ssl);
    }

    public BinaryClient(final String host, final int port, final boolean ssl,
                        final SSLSocketFactory sslSocketFactory, final SSLParameters sslParameters,
                        final HostnameVerifier hostnameVerifier) {
        super(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }
    public boolean isInMulti() {
        return isInMulti;
    }
    public boolean isInWatch() {
        return isInWatch;
    }

    @Override
    public void connect() {
        if (!isConnected()) {
            super.connect();
            if (password != null) {
                auth(password);
                getStatusCodeReply();
            }
            if (db > 0) {
                select(Long.valueOf(db).intValue());
                getStatusCodeReply();
            }
        }
    }
    public void auth(final String password) {
        setPassword(password);
        sendCommand(GlobalCommand.AUTH, password);
    }
    public void setPassword(final String password) {
        this.password = password;
    }
    public void ping() {
        sendCommand(GlobalCommand.PING);
    }

    public void set(final byte[] key, final byte[] value) {
        sendCommand(GlobalCommand.SET, key, value);
    }
    public void setex(final byte[] key, final int seconds, final byte[] value) {
        sendCommand(GlobalCommand.SETEX, key, toByteArray(seconds), value);
    }

    public void setnx(final byte[] key, final byte[] value) {
        sendCommand(GlobalCommand.SETNX, key, value);
    }

    public void setrange(byte[] key, long offset, byte[] value) {
        sendCommand(GlobalCommand.SETRANGE, key, toByteArray(offset), value);
    }

    public void strlen(final byte[] key) {
        sendCommand(GlobalCommand.STRLEN, key);
    }

    public void hdel(final byte[] key, final byte[]... fields) {
        sendCommand(GlobalCommand.HDEL, joinParameters(key, fields));
    }

    public void hexists(final byte[] key, final byte[] field) {
        sendCommand(GlobalCommand.HEXISTS, key, field);
    }

    public void hget(final byte[] key, final byte[] field) {
        sendCommand(GlobalCommand.HGET, key, field);
    }

    public void hgetAll(final byte[] key) {
        sendCommand(GlobalCommand.HGETALL, key);
    }
    public void hincrBy(final byte[] key, final byte[] field, final long value) {
        sendCommand(GlobalCommand.HINCRBY, key, field, toByteArray(value));
    }

    public void hincrByFloat(final byte[] key, final byte[] field, double increment) {
        sendCommand(GlobalCommand.HINCRBYFLOAT, key, field, toByteArray(increment));
    }
    public void hlen(final byte[] key) {
        sendCommand(GlobalCommand.HLEN, key);
    }

    public void hkeys(final byte[] key) {
        sendCommand(GlobalCommand.HKEYS, key);
    }
    public void hmset(final byte[] key, final Map<byte[], byte[]> hash) {
        final List<byte[]> params = new ArrayList<byte[]>();
        params.add(key);

        for (final Entry<byte[], byte[]> entry : hash.entrySet()) {
            params.add(entry.getKey());
            params.add(entry.getValue());
        }
        sendCommand(GlobalCommand.HMSET, params.toArray(new byte[params.size()][]));
    }
    public void hmget(final byte[] key, final byte[]... fields) {
        final byte[][] params = new byte[fields.length + 1][];
        params[0] = key;
        System.arraycopy(fields, 0, params, 1, fields.length);
        sendCommand(GlobalCommand.HMGET, params);
    }
    public void hset(final byte[] key, final byte[] field, final byte[] value) {
        sendCommand(GlobalCommand.HSET, key, field, value);
    }
    public void hsetnx(final byte[] key, final byte[] field, final byte[] value) {
        sendCommand(GlobalCommand.HSETNX, key, field, value);
    }
    public void hvals(final byte[] key) {
        sendCommand(GlobalCommand.HVALS, key);
    }
    public void lindex(final byte[] key, final long index) {
        sendCommand(GlobalCommand.LINDEX, key, toByteArray(index));
    }
    public void linsert(final byte[] key, final GlobalPosition where, final byte[] pivot,
                        final byte[] value) {
        sendCommand(GlobalCommand.LINSERT, key, where.raw, pivot, value);
    }
    public void llen(final byte[] key) {
        sendCommand(GlobalCommand.LLEN, key);
    }
    public void lpop(final byte[] key) {
        sendCommand(GlobalCommand.LPOP, key);
    }
    public void lpush(final byte[] key, final byte[]... strings) {
        sendCommand(GlobalCommand.LPUSH, joinParameters(key, strings));
    }
    public void lpushx(final byte[] key, final byte[]... string) {
        sendCommand(GlobalCommand.LPUSHX, joinParameters(key, string));
    }
    public void lrange(final byte[] key, final long start, final long end) {
        sendCommand(GlobalCommand.LRANGE, key, toByteArray(start), toByteArray(end));
    }
    public void lrem(final byte[] key, long count, final byte[] value) {
        sendCommand(GlobalCommand.LREM, key, toByteArray(count), value);
    }
    public void lset(final byte[] key, final long index, final byte[] value) {
        sendCommand(GlobalCommand.LSET, key, toByteArray(index), value);
    }
    public void ltrim(final byte[] key, final long start, final long end) {
        sendCommand(GlobalCommand.LTRIM, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }
    public void rpop(final byte[] key) {
        sendCommand(GlobalCommand.RPOP, key);
    }

    public void rpoplpush(final byte[] srckey, final byte[] dstkey) {
        sendCommand(GlobalCommand.RPOPLPUSH, srckey, dstkey);
    }
    public void rpush(final byte[] key, final byte[]... strings) {
        sendCommand(GlobalCommand.RPUSH, joinParameters(key, strings));
    }
    public void rpushx(final byte[] key, final byte[]... string) {
        sendCommand(GlobalCommand.RPUSHX, joinParameters(key, string));
    }
    public void sadd(final byte[] key, final byte[]... members) {
        sendCommand(GlobalCommand.SADD, joinParameters(key, members));
    }
    public void scard(final byte[] key) {
        sendCommand(GlobalCommand.SCARD, key);
    }
    public void sdiff(final byte[]... keys) {
        sendCommand(GlobalCommand.SDIFF, keys);
    }
    public void sdiffstore(final byte[] dstkey, final byte[]... keys) {
        byte[][] params = new byte[keys.length + 1][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand(GlobalCommand.SDIFFSTORE, params);
    }
    public void sinter(final byte[]... keys) {
        sendCommand(GlobalCommand.SINTER, keys);
    }

    public void sinterstore(final byte[] dstkey, final byte[]... keys) {
        final byte[][] params = new byte[keys.length + 1][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand(GlobalCommand.SINTERSTORE, params);
    }
    public void sismember(final byte[] key, final byte[] member) {
        sendCommand(GlobalCommand.SISMEMBER, key, member);
    }
    public void smembers(final byte[] key) {
        sendCommand(GlobalCommand.SMEMBERS, key);
    }

    public void smove(final byte[] srckey, final byte[] dstkey, final byte[] member) {
        sendCommand(GlobalCommand.SMOVE, srckey, dstkey, member);
    }
    public void spop(final byte[] key) {
        sendCommand(GlobalCommand.SPOP, key);
    }

    public void spop(final byte[] key, final long count) {
        sendCommand(GlobalCommand.SPOP, key, toByteArray(count));
    }
    public void srandmember(final byte[] key) {
        sendCommand(GlobalCommand.SRANDMEMBER, key);
    }
    public void srem(final byte[] key, final byte[]... members) {
        sendCommand(GlobalCommand.SREM, joinParameters(key, members));
    }
    public void sunion(final byte[]... keys) {
        sendCommand(GlobalCommand.SUNION, keys);
    }

    public void sunionstore(final byte[] dstkey, final byte[]... keys) {
        byte[][] params = new byte[keys.length + 1][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand(GlobalCommand.SUNIONSTORE, params);
    }
    public void discard() {
        sendCommand(GlobalCommand.DISCARD);
        isInMulti = false;
        isInWatch = false;
    }
    public void exec() {
        sendCommand(GlobalCommand.EXEC);
        isInMulti = false;
        isInWatch = false;
    }
    public void multi() {
        sendCommand(GlobalCommand.MULTI);
        isInMulti = true;
    }
    public void watch(final byte[]... keys) {
        sendCommand(GlobalCommand.WATCH, keys);
        isInWatch = true;
    }
    public void del(final byte[]... keys) {
        sendCommand(GlobalCommand.DEL, keys);
    }

    public void exists(final byte[]... key) {
        sendCommand(GlobalCommand.EXISTS, key);
    }
    public void expire(final byte[] key, final int seconds) {
        sendCommand(GlobalCommand.EXPIRE, key, toByteArray(seconds));
    }
    public void expireAt(final byte[] key, final long unixTime) {
        sendCommand(GlobalCommand.EXPIREAT, key, toByteArray(unixTime));
    }
    public void ttl(final byte[] key) {
        sendCommand(GlobalCommand.TTL, key);
    }
    public void keys(final byte[] pattern) {
        sendCommand(GlobalCommand.KEYS, pattern);
    }
    public void move(final byte[] key, final int dbIndex) {
        sendCommand(GlobalCommand.MOVE, key, toByteArray(dbIndex));
    }
    public void persist(final byte[] key) {
        sendCommand(GlobalCommand.PERSIST, key);
    }
    public void pttl(final byte[] key) {
        sendCommand(GlobalCommand.PTTL, key);
    }
    public void sort(final byte[] key) {
        sendCommand(GlobalCommand.SORT, key);
    }

    public void sort(final byte[] key, final SortingParams sortingParameters) {
        final List<byte[]> args = new ArrayList<byte[]>();
        args.add(key);
        args.addAll(sortingParameters.getParams());
        sendCommand(GlobalCommand.SORT, args.toArray(new byte[args.size()][]));
    }
    public void type(final byte[] key) {
        sendCommand(GlobalCommand.TYPE, key);
    }
    public void append(final byte[] key, final byte[] value) {
        sendCommand(GlobalCommand.APPEND, key, value);
    }
    public void decrBy(final byte[] key, final long integer) {
        sendCommand(GlobalCommand.DECRBY, key, toByteArray(integer));
    }

    public void decr(final byte[] key) {
        sendCommand(GlobalCommand.DECR, key);
    }
    public void get(final byte[] key) {
        sendCommand(GlobalCommand.GET, key);
    }
    public void getrange(byte[] key, long startOffset, long endOffset) {
        sendCommand(GlobalCommand.GETRANGE, key, toByteArray(startOffset), toByteArray(endOffset));
    }
    public void getSet(final byte[] key, final byte[] value) {
        sendCommand(GlobalCommand.GETSET, key, value);
    }
    public void incrBy(final byte[] key, final long integer) {
        sendCommand(GlobalCommand.INCRBY, key, toByteArray(integer));
    }

    public void incrByFloat(final byte[] key, final double value) {
        sendCommand(GlobalCommand.INCRBYFLOAT, key, toByteArray(value));
    }
    public void incr(final byte[] key) {
        sendCommand(GlobalCommand.INCR, key);
    }
    public void mget(final byte[]... keys) {
        sendCommand(GlobalCommand.MGET, keys);
    }
    public void mset(final byte[]... keysvalues) {
        sendCommand(GlobalCommand.MSET, keysvalues);
    }

    public void msetnx(final byte[]... keysvalues) {
        sendCommand(GlobalCommand.MSETNX, keysvalues);
    }
    public void quit() {
        db = 0;
        sendCommand(GlobalCommand.QUIT);
    }

    public void select(final int index) {
        sendCommand(GlobalCommand.SELECT, toByteArray(index));
    }
    public void info() {
        sendCommand(GlobalCommand.INFO);
    }

    public void info(final String section) {
        sendCommand(GlobalCommand.INFO, section);
    }

    private byte[][] joinParameters(byte[] first, byte[][] rest) {
        byte[][] result = new byte[rest.length + 1][];
        result[0] = first;
        System.arraycopy(rest, 0, result, 1, rest.length);
        return result;
    }
}
