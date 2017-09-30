package com.lww.mail.beanF;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MailFreeMarkHtmlBody implements MailBody {
    private String path;
    private String fileName;
    private Map<String, Object> params;
    private String type;    //邮件类型以及编码
    private String subject;
    private static final String DEFAULT_TYPE= "text/html;charset=UTF-8";

    public MailFreeMarkHtmlBody(String path, String fileName) {
        this(path, fileName, null);
    }

    public MailFreeMarkHtmlBody(String path, String fileName, String subject) {
        this(path, fileName, subject, new HashMap());
    }

    public MailFreeMarkHtmlBody(String path, String fileName, String subject, Map<String, Object> params) {
        this(path, fileName, subject, params, DEFAULT_TYPE);
    }

    public MailFreeMarkHtmlBody(String path, String fileName, String subject, Map<String, Object> params, String type) {
        this.path = path;
        this.fileName = fileName;
        this.subject = subject;
        this.params = params;
        this.type = type;
    }

    public void addParam(String key, Object value) {
        synchronized (params) {
            params.put(key, value);
        }
    }

    @Override
    public String getBody() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        StringWriter writer  = new StringWriter();
        configuration.setDirectoryForTemplateLoading(new File(path));
        Template template = configuration.getTemplate(fileName);
        template.process(params, writer);
        return writer.toString();
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
