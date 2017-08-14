package com.lww.ledis.commands;

/**
 * Created by lenovo on 2017/7/27.
 */
public interface ConnectionCommands {
    String ping();
    String quit();
    String auth(String password);



}
