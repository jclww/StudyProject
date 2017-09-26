package com.lww.mail.test;

import com.lww.mail.enity.MailReceiver;
import com.lww.mail.enity.SendHtmlMailBean;
import com.lww.mail.send.SendHtmlMail;
import com.lww.mail.utils.Global;

import java.util.HashMap;
import java.util.Map;

public class HtmlTest {
    public static void main(String[] args) {
    String host = "smtp.btte.net";
    String user = "liweiwei6@btte.net";
    String passWord = "wsNhfzJd@742";
    String name = "测试title";

    SendHtmlMailBean mailBean = new SendHtmlMailBean(host,user,passWord,name);
    mailBean.setPort(Global.DEFAULT_SSL_PORT);
    mailBean.setSubject("测试主题");
    MailReceiver receiver = new MailReceiver("1377877153@qq.com");

    mailBean.addRecever(receiver);
    mailBean.addCarbonCopy("18720594171@163.com","163Mail");

    mailBean.setFileName("user.ftl");
    mailBean.setPath("c:\\");
    Map<String, Object> map = new HashMap();
    map.put("user", "测试");
    mailBean.setParams(map);

//        mailBean.setType("text/html;charset=UTF-8");
//        mailBean.set
    SendHtmlMail sendHtmlMail = new SendHtmlMail();
    sendHtmlMail.setNeedAuth(true);
    sendHtmlMail.setNeedSSL(true);
//        sendPlainMail.setDebug(true);
    sendHtmlMail.sendMail(mailBean);
}

}
