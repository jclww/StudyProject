package com.lww.mail.send;

public interface SendMail<T> {
    static final String SEND_SUCCESS = "SUCCESS";
    static final String SEND_ERROR = "ERROR";

    String sendMail(T mailBean);
}
