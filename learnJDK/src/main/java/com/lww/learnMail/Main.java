package com.lww.learnMail;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Main {

    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "liweiwei6@btte.net";
    public static String myEmailPassword = "wsNhfzJd@742";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.btte.net";

    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "liweiwei6@btte.net";

    public static void main(String[] args) throws Exception {


        Properties prop = new Properties();
// 开启debug调试，以便在控制台查看
//        prop.setProperty("mail.debug", "true");
// 设置邮件服务器主机名
        prop.setProperty("mail.host", myEmailSMTPHost);
// 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");
// 发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        // 创建session
        Session session = Session.getInstance(prop);
// 通过session得到transport对象
        Transport ts = session.getTransport();
// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        ts.connect("smtp.btte.net","liweiwei6@btte.net", "wsNhfzJd@742");//后面的字符是授权码，用qq密码反正我是失败了（用自己的，别用我的，这个号是我瞎编的，为了。。。。）
// 创建邮件
        Message message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
// 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("liweiwei6@btte.net", "XX用户", "UTF-8"));
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1377877153@qq.com", "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("打折钜惠", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("test", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

}