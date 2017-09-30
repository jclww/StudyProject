package com.lww.mail.beanF.test;

import com.lww.mail.beanF.*;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lww on 2017/9/30.
 */
public class TestFreeMarkerMail {
    static String host = "smtp.btte.net";
    static int port = 25;
    static int ssl_port = 465;
    static String mail = "liweiwei6@btte.net";
    static String passWord = "wsNhfzJd@742";
    static String subject = "测试Freemark主题";

    static String path = "C:\\freemarker\\";
    static String fileName = "user.ftl";


    static String r_mail1 = "1377877153@qq.com";
    static String r_mail2 = "18720594171@163.com";
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        Sender sender = new Sender(host, port, mail, passWord,"23333");
        JavaMail mail = new JavaMail();
        MailFreeMarkHtmlBody body = new MailFreeMarkHtmlBody(path, fileName, subject);
        Map map = new HashMap();
        map.put("user", "王八蛋");
        map.put("img1", "cid:333");
        map.put("img2", "cid:222");
        String img3 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2586622310,1955960616&fm=27&gp=0.jpg";
        map.put("img3", img3);
        body.setParams(map);

        MailProperties properties = new MailProperties(true);

        List<Receiver> receiverList = new ArrayList<>();
        receiverList.add(new Receiver(r_mail1,"qq邮箱"));
        receiverList.add(new Receiver(r_mail2,"163邮箱"));

        List<Image> imageList = new ArrayList<>();
        Image img1 = new Image("333","C:\\freemarker\\img\\img1.jpg");
        Image img2 = new Image("222","C:\\freemarker\\img\\img1.jpg");
        imageList.add(img1);
        imageList.add(img2);

        mail.setSender(sender);
        mail.addBody(body)
                .addProperties(properties)
                .addReceiver(receiverList.get(0))
                .addCarbonCopy(receiverList.get(1))
                .addImgList(imageList);
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
        //计算总共花费时间
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }
}
