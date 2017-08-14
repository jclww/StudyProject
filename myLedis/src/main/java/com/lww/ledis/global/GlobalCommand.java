package com.lww.ledis.global;


import redis.clients.util.SafeEncoder;

/**
 * Created by Lww on 2017/7/26.
 */
public enum GlobalCommand {
    //http://doc.redisfans.com/index.html
    /* Server服务器    字符串     key（键）      List       SortedSet           Set         Hash         发布订阅      Script(脚本)  事物      connection*/

    BGREWRITEAOF,	APPEND,	    DEL,	    BLPOP,	    ZADD,	            SADD,	    HDEL,	     PSUBSCRIBE,  EVAL,	       DISCARD,	AUTH,
    BGSAVE,	        BITCOUNT,	DUMP,	    BRPOP,	    ZCARD,	            SCARD,  	HEXISTS,	 PUBLISH,	  EVALSHA,     EXEC,	ECHO,
    CLIENTGETNAME,	BITOP,	    EXISTS,	    BRPOPLPUSH,	ZCOUNT,	            SDIFF,  	HGET,	     PUBSUB,	  SCRIPTEXISTS,MULTI,	PING,
    CLIENTKILL,	    DECR,	    EXPIRE,	    LINDEX,	    ZINCRBY,        	SDIFFSTORE,	HGETALL,	 PUNSUBSCRIBE,SCRIPTFLUSH, UNWATCH,	QUIT,
    CLIENTLIST, 	DECRBY,	    EXPIREAT,	LINSERT,	ZRANGE,	            SINTER,	    HINCRBY,	 SUBSCRIBE,	  SCRIPTKILL,  WATCH,	SELECT,
    CLIENTSETNAME,	GET,	    KEYS,	    LLEN,	    ZRANGEBYSCORE,	    SINTERSTORE,HINCRBYFLOAT,UNSUBSCRIBE, SCRIPTLOAD,
    CONFIGGET,	    GETBIT,	    MIGRATE,	LPOP,	    ZRANK,	            SISMEMBER,	HKEYS,
    CONFIGRESETSTAT,GETRANGE,	MOVE,	    LPUSH,	    ZREM,	            SMEMBERS,	HLEN,
    CONFIGREWRITE,	GETSET,	    OBJECT,	    LPUSHX, 	ZREMRANGEBYRANK,	SMOVE,	    HMGET,
    CONFIGSET,	    INCR,	    PERSIST,	LRANGE,	    ZREMRANGEBYSCORE,	SPOP,	    HMSET,
    DBSIZE,	        INCRBY,	    PEXPIRE,	LREM,       ZREVRANGE,	        SRANDMEMBER,HSET,
    DEBUGOBJECT,	INCRBYFLOAT,PEXPIREAT,	LSET,	    ZREVRANGEBYSCORE,	SREM,	    HSETNX,
    DEBUGSEGFAULT,	MGET,   	PTTL,	    LTRIM,  	ZREVRANK,	        SUNION,	    HVALS,
    FLUSHALL,	    MSET,	    RANDOMKEY,	RPOP,	    ZSCORE,	            SUNIONSTORE,HSCAN,
    FLUSHDB,	    MSETNX, 	RENAME,	    RPOPLPUSH,	ZUNIONSTORE,	    SSCAN,
    INFO,	        PSETEX, 	RENAMENX,	RPUSH,	    ZINTERSTORE,
    LASTSAVE,   	SET,	    RESTORE,	RPUSHX,	    ZSCAN,
    MONITOR,	    SETBIT, 	SORT,
    PSYNC,	        SETEX,	    TTL,
    SAVE,	        SETNX,	    TYPE,
    SHUTDOWN,	    SETRANGE,	SCAN,
    SLAVEOF,	    STRLEN,
    SLOWLOG,
    SYNC,
    TIME;
    public final byte[] raw;

    GlobalCommand() {
        raw = SafeEncoder.encode(this.name());
    }

    }