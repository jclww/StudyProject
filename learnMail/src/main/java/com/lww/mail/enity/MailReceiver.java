package com.lww.mail.enity;

public class MailReceiver {
    private String mail;

    private String personal;

    public MailReceiver(String mail, String personal) {
        this.mail = mail;
        this.personal = personal;
    }

    public MailReceiver(String mail) {
        this.mail = mail;
    }

    /** GET SET **/
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
}
