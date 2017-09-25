package com.lww.mail.enity;


import java.util.ArrayList;
import java.util.List;

public class SendMailBean extends MailBean{

    private List<MailReceiver> receives = new ArrayList<>();         //收信人
    private List<MailReceiver> carbonCopy = new ArrayList<>();       //Carbon Copy, 抄送邮件给某人
    private List<MailReceiver> blindCarbonCopy = new ArrayList<>();  //bcc Blind Carbon Copy,隐蔽副本 隐蔽抄送给某人
    private String subject;   //邮件主题

    public SendMailBean(String host, String user, String passWord, String from) {
        super(host, user, passWord, from);
    }
    public SendMailBean(String host, String user, String passWord, String from, int port) {
        super(host, user, passWord, from, port);
    }



    /** GET   SET**/
    public List<MailReceiver> getReceives() {
        return receives;
    }

    public void setReceives(List<MailReceiver> receives) {
        this.receives = receives;
    }

    public List<MailReceiver> getCarbonCopy() {
        return carbonCopy;
    }

    public void setCarbonCopy(List<MailReceiver> carbonCopy) {
        this.carbonCopy = carbonCopy;
    }

    public List<MailReceiver> getBlindCarbonCopy() {
        return blindCarbonCopy;
    }

    public void setBlindCarbonCopy(List<MailReceiver> blindCarbonCopy) {
        this.blindCarbonCopy = blindCarbonCopy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void addRecever(MailReceiver receiver) {
        synchronized (receives) {
            this.receives.add(receiver);
        }
    }
    public void addRecever(String mail, String personal) {
        synchronized (receives) {
            this.receives.add(new MailReceiver(mail, personal));
        }
    }

    public void addCarbonCopy(MailReceiver receiver) {
        synchronized (carbonCopy) {
            this.carbonCopy.add(receiver);
        }
    }
    public void addCarbonCopy(String mail, String personal) {
        synchronized (carbonCopy) {
            this.carbonCopy.add(new MailReceiver(mail, personal));
        }
    }

    public void addBlindCarbonCopy(MailReceiver receiver) {
        synchronized (blindCarbonCopy) {
            this.blindCarbonCopy.add(receiver);
        }
    }
    public void addBlindCarbonCopy(String mail, String personal) {
        synchronized (blindCarbonCopy) {
            this.blindCarbonCopy.add(new MailReceiver(mail, personal));
        }
    }
}
