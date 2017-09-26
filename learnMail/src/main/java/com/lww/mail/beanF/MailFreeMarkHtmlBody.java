package com.lww.mail.beanF;

import java.util.HashMap;
import java.util.Map;

public class MailFreeMarkHtmlBody implements MailBody {
    private String path;
    private String fileName;
    private Map<String, Object> params;
    private String type;    //邮件类型以及编码
    private static final String DEFAULT_TYPE= "text/html;charset=UTF-8";

    public MailFreeMarkHtmlBody(String path, String fileName) {
        this(path, fileName, new HashMap());
    }

    public MailFreeMarkHtmlBody(String path, String fileName, Map<String, Object> params) {
        this(path, fileName, params, DEFAULT_TYPE);
    }

    public MailFreeMarkHtmlBody(String path, String fileName, Map<String, Object> params, String type) {
        this.path = path;
        this.fileName = fileName;
        this.params = params;
        this.type = type;
    }

    public void addParam(String key, Object value) {
        synchronized (params) {
            params.put(key, value);
        }
    }

    @Override
    public String getBody() {
        return null;
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
