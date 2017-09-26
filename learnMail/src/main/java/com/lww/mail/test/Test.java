package com.lww.mail.test;

import com.lww.mail.enity.MailReceiver;
import com.lww.mail.enity.SendPlainMailBean;
import com.lww.mail.send.SendPlainMail;
import com.lww.mail.utils.Global;

public class Test {
    public static void main(String[] args) {

        String host = "smtp.btte.net";
        String user = "liweiwei6@btte.net";
        String passWord = "wsNhfzJd@742";
        String name = "测试title";

        SendPlainMailBean mailBean = new SendPlainMailBean(host,user,passWord,name);
        mailBean.setPort(Global.DEFAULT_SSL_PORT);
        mailBean.setSubject("测试主题");
        MailReceiver receiver = new MailReceiver("1377877153@qq.com");

        mailBean.addRecever(receiver);
        mailBean.addCarbonCopy("18720594171@163.com","163Mail");

        mailBean.setBody("测试<h3>sdsada<h3>");
//        mailBean.setType("text/html;charset=UTF-8");
//        mailBean.set
        SendPlainMail sendPlainMail = new SendPlainMail();
        sendPlainMail.setNeedAuth(true);
        sendPlainMail.setNeedSSL(true);
//        sendPlainMail.setDebug(true);
        sendPlainMail.sendMail(mailBean);
    }
}
