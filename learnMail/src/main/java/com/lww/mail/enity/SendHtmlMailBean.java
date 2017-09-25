package com.lww.mail.enity;

import java.util.HashMap;
import java.util.Map;

public class SendHtmlMailBean extends SendMailBean {
    private String path;
    private String fileName;
    private Map<String, Object> params = new HashMap();
    private String type;    //邮件类型以及编码

    private static final String DEFAULT_TYPE= "text/html;charset=UTF-8";

    public SendHtmlMailBean(String host, String user, String passWord, String from) {
        super(host, user, passWord, from);
    }

    public SendHtmlMailBean(String host, String user, String passWord, String from, int port) {
        super(host, user, passWord, from, port);
    }

    /** GET SET **/
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        if (type == null || type.length() < 1) {
            return DEFAULT_TYPE;
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
