package com.lww.mail.enity;

public class SendPlainMailBean extends SendMailBean {

    private String body;    //邮件内容
    private String type;    //邮件类型以及编码
    private static final String DEFAULT_TYPE= "text/html;charset=UTF-8";

    public SendPlainMailBean(String host, String user, String passWord, String from) {
        super(host, user, passWord, from);
    }
    public SendPlainMailBean(String host, String user, String passWord, String from, int port) {
        super(host, user, passWord, from, port);
    }

    /** GET SET **/
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        if (type == null) {
            return DEFAULT_TYPE;
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
