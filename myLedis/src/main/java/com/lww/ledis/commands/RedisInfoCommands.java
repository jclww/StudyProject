package com.lww.ledis.commands;

/**
 * Created by lenovo on 2017/8/1.
 */
public interface RedisInfoCommands {
    public String getRedisRole();

    public void getRedisInfo(String... keys);



//    Long dbSize();
    public String info();
//
//    String info(String section);

//    String slaveof(String host, int port);
//
//    String slaveofNoOne();
}
