package com.lww.mail.beanF.test;

import com.lww.mail.beanF.*;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lww on 2017/9/30.
 */
public class TestStringMail {
    static String host = "smtp.btte.net";
    static int port = 25;
    static int ssl_port = 465;
    static String mail = "liweiwei6@btte.net";
    static String passWord = "wsNhfzJd@742";
    static String title = "测试title";
    static String context = "测试发送string类型";


    static String r_mail1 = "1377877153@qq.com";
    static String r_mail2 = "18720594171@163.com";
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        Sender sender = new Sender(host, port, mail, passWord);
        JavaMail mail = new JavaMail();
        MailBody body = new MailStringBody(context, title);

        MailProperties properties = new MailProperties(true);

        List<Receiver> receiverList = new ArrayList<>();
        receiverList.add(new Receiver(r_mail1,"qq邮箱"));
        receiverList.add(new Receiver(r_mail2,"163邮箱"));

        mail.setSender(sender);
        mail.addBody(body)
                .addProperties(properties)
                .addReceiver(receiverList.get(0))
                .addCarbonCopy(receiverList.get(1));

        try {
            mail.sendMail();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
