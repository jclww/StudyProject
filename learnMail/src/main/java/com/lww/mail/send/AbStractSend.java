package com.lww.mail.send;

import com.lww.mail.enity.MailBean;
import com.lww.mail.enity.MailReceiver;
import com.lww.mail.enity.SendPlainMailBean;
import com.lww.mail.utils.Global;
import com.lww.mail.utils.MailAuthenticator;
import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class AbStractSend {
    protected static final Logger logger = LoggerFactory.getLogger(AbStractSend.class);
    protected boolean needAuth;
    protected boolean needSSL;
    protected boolean debug;
    public AbStractSend(String protol) {
        this.protol = protol;
    }

    protected String protol;

    public Session getSession(MailBean mailBean){
        Properties props = new Properties();
        if (debug) {
            props.setProperty("mail.debug", "true");
        }
        if (needAuth) {
            props.put("mail.smtp.auth", "true");
        }
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailBean.getHost());
        props.put("mail.smtp.port", mailBean.getPort());
        if (needSSL) {
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                props.put("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.socketFactory", sf);
            } catch (GeneralSecurityException e) {
                logger.error(e.getMessage());
            }
        }
        props.setProperty("mail.transport.protocol", protol.toLowerCase());
        Authenticator authenticator = new MailAuthenticator(mailBean.getUser(),mailBean.getPassWord());
        Session session = Session.getDefaultInstance(props,authenticator);
        return session;
    }



    public boolean isNeedAuth() {
        return needAuth;
    }

    public void setNeedAuth(boolean needAuth) {
        this.needAuth = needAuth;
    }

    public boolean isNeedSSL() {
        return needSSL;
    }

    public void setNeedSSL(boolean needSSL) {
        this.needSSL = needSSL;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
