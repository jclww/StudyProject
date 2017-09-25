package com.lww.mail.freemark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
//        System.out.println(System.getProperty("user.dir"));


        configuration.setDirectoryForTemplateLoading(new File("C:\\"));

//        configuration.setDirectoryForTemplateLoading(new File("user.ftl"));

        Template template = configuration.getTemplate("user.ftl");
        Map map = new HashMap();
        map.put("user", "测试");
//        OutputStream out=System.out;
        StringWriter writer  = new StringWriter();
        template.process(map, writer);

        String s = writer.toString();
        System.out.println(s);
    }
}
