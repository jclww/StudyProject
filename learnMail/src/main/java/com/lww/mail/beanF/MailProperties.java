package com.lww.mail.beanF;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailProperties {
    protected static final Logger logger = LoggerFactory.getLogger(MailProperties.class);

    // boolean 是否开启调试模式 "true"字符串表示
    static final String MAIL_DEBUG = "mail.debug";
    // boolean 是否需要认证 "true"字符串表示
    static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    // String 服务器地址
    static final String MAIL_SMTP_HOST = "mail.smtp.host";
    // int 端口
    static final String MAIL_SMTP_PORT = "mail.smtp.port";
    // boolean 是否需要使用ssl加密  "true"
    static final String MAIL_SMTP_SSL_ENABLE = "mail.smtp.ssl.enable";
    // MailSSLSocketFactory 加密
    static final String MAIL_SMTP_SSL_SOCKETFACTORY = "mail.smtp.ssl.socketFactory";
    // 邮件协议 SMTP
    static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";

    static final String TRUE = "true";
    static final String FALSE = "false";


    private Properties props;
    private boolean needAuth;
    private boolean needSSL;
    private boolean debug;
    private MailSSLSocketFactory sf;

    public MailProperties(boolean needAuth) {
        this(needAuth, false,false);
    }

    public MailProperties(boolean needAuth, boolean needSSL) {
        this(needAuth, needSSL,false);
    }

    public MailProperties(boolean needAuth, boolean needSSL, boolean debug) {
        this.needAuth = needAuth;
        this.needSSL = needSSL;
        this.debug = debug;
        initProperties();
    }

    public void initProperties() {
        this.props = new Properties();
        if (this.debug) {
            props.setProperty(MAIL_DEBUG, TRUE);
        }
        if (this.needAuth) {
            props.put(MAIL_SMTP_AUTH, TRUE);
        }
        props.put(MAIL_SMTP_STARTTLS_ENABLE, TRUE);
//        props.put(MAIL_SMTP_HOST, mailBean.getHost());
//        props.put(MAIL_SMTP_PORT, mailBean.getPort());
        if (needSSL) {
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                props.put(MAIL_SMTP_SSL_ENABLE, "true");
                props.put(MAIL_SMTP_SSL_SOCKETFACTORY, sf);
            } catch (GeneralSecurityException e) {
                logger.error("创建SSL安全连接失败");
            }
        }
//        props.setProperty(MAIL_TRANSPORT_PROTOCOL, protol.toLowerCase());
    }


    /**
     * 获取Properties
     * @return
     */
    public Properties getProps() {
        return props;
    }
}
