package com.lww.mail.beanF;

public class Sender {
    private String mailHost;
    private int hostPort;
    private String mail;
    private String passWord;
    private String personal;

    public Sender(String mailHost, int hostPort, String mail, String passWord) {
        this(mailHost, hostPort, mail, passWord, null);
    }

    public Sender(String mailHost, int hostPort, String mail, String passWord, String personal) {
        this.mailHost = mailHost;
        this.hostPort = hostPort;
        this.mail = mail;
        this.passWord = passWord;
        this.personal = personal;
    }

    /** GET SET **/
    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
    //    String host = "smtp.btte.net";
//    String user = "liweiwei6@btte.net";
//    String passWord = "wsNhfzJd@742";
//    String name = "测试title";
}
