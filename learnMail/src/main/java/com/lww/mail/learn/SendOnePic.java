package com.lww.mail.learn;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

public class SendOnePic {
    public static String myEmailAccount = "liweiwei6@btte.net";
    public static String myEmailPassword = "wsNhfzJd@742";
    public static String myEmailSMTPHost = "smtp.btte.net";
    public static String receiveMailAccount = "liweiwei6@btte.net";

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
//        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.host", myEmailSMTPHost);
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.transport.protocol", "smtp");
        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(prop);
        Transport ts = session.getTransport();
        ts.connect("smtp.btte.net","liweiwei6@btte.net", myEmailPassword);//后面的字符是授权码
        Message message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "图片测试", "UTF-8"));
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("18720594171@163.com", "XX用户", "UTF-8"));
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1377877153@qq.com", "XX用户", "UTF-8"));


        // 4. Subject: 邮件主题
        message.setSubject("图片测试主题", "UTF-8");

        MimeMultipart multipart = new MimeMultipart("related");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Hello</H1><img src=\"cid:666\"><br><h1>图片2<h1/><img src=\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2586622310,1955960616&fm=27&gp=0.jpg\">";
        messageBodyPart.setContent(htmlText, "text/html ");
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = null;

        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\mailtest\\img\\test.jpg");
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setContentID("666");
        multipart.addBodyPart(messageBodyPart);

//        MimeBodyPart gifBodyPart=new MimeBodyPart();
//        gifBodyPart.setContentID("as");   //cid的值


        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(multipart);


        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.setSubType("mixed");
        message.setContent(mm);

//        message.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}
