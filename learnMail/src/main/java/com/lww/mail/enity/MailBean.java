package com.lww.mail.enity;


public class MailBean {
    private String host;      //邮件服务器
    private int port;         //服务器端口
    private String user;      //用户名
    private String passWord;  //用户密码
    private String from;      //发信人
    private static final int DEFAULT_PORT = 25;
    private static final int DEFAULT_SSL_PORT = 465;

    public MailBean(String host, String user, String passWord, String from) {
        this(host,user,passWord,from,DEFAULT_PORT);
    }
    public MailBean(String host, String user, String passWord, String from, int port) {
        this.host = host;
        this.user = user;
        this.passWord = passWord;
        this.from = from;
        this.port = port;
    }

    /** GET SET **/
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
