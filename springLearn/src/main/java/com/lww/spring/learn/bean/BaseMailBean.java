package com.lww.spring.learn.bean;

/**
 * Created by Lww on 2017/9/22.
 */
public class BaseMailBean {
    //发送方账号
    public String sendMail;
    //密码
    public String sendMailPassWord;

    public String protocol;
    //发送方邮箱服务器
    public String sendHostServer;

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    public String getSendMailPassWord() {
        return sendMailPassWord;
    }

    public void setSendMailPassWord(String sendMailPassWord) {
        this.sendMailPassWord = sendMailPassWord;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSendHostServer() {
        return sendHostServer;
    }

    public void setSendHostServer(String sendHostServer) {
        this.sendHostServer = sendHostServer;
    }
}

