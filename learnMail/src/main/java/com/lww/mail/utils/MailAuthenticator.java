package com.lww.mail.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {
    private String user;      //用户名
    private String passWord;  //用户密码

    public MailAuthenticator(String user, String passWord) {
        this.user = user;
        this.passWord = passWord;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, passWord);
    }
}
