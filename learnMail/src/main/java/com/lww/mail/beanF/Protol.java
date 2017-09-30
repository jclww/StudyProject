package com.lww.mail.beanF;

/**
 * Created by Lww on 2017/9/29.
 */
public enum Protol {
    SMTP("smtp");

    String protol;
    Protol(String protol) {
        this.protol = protol;
    }

    public String getProtol() {
        return protol;
    }
}
