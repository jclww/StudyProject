package com.lww.mail.beanF;

public class Receiver {

    private String mail;
    private String personal;

    public Receiver(String mail, String personal) {
        this.mail = mail;
        this.personal = personal;
    }

    public Receiver(String mail) {
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
