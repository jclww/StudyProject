package com.lww.mail.beanF;

public class MailStringBody implements MailBody {
    private String content;
    private String type;
    private String subject;
    private static final String DEFAULT_TYPE= "text/html;charset=UTF-8";

//    public MailStringBody(String content) {
//        this(content, null);
//    }


    public MailStringBody(String content, String subject) {
        this(content, DEFAULT_TYPE, subject);
    }

    public MailStringBody(String content, String type, String subject) {
        this.content = content;
        this.type = type;
        this.subject = subject;
    }

    @Override
    public String getBody() {
        return content;
    }

    /** GET SET **/
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
