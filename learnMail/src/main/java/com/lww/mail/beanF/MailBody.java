package com.lww.mail.beanF;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface MailBody  {
    String getBody() throws IOException, TemplateException;
    String getType();
    String getSubject();
}
