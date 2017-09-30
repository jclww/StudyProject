package com.lww.mail.beanF;

import com.lww.mail.utils.Global;
import com.lww.mail.utils.MailAuthenticator;
import freemarker.template.TemplateException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class JavaMail {

    public JavaMail() {

    }

    public JavaMail(Sender sender) {
        this.sender = sender;
    }


    public void sendMail() throws IOException, MessagingException, TemplateException {
        if (sender != null) {
            //初始时间
//            long begin = System.currentTimeMillis();

            Session session = createSession(Protol.SMTP.getProtol());
            //创建邮件信息
            Message msg = createMessage(session);
            Transport ts = session.getTransport();
            //计算创建消息所消耗时间
//            long temp2 = System.currentTimeMillis();
//            System.out.println("Create Message"+(temp2 - begin));

//            ts.connect(sender.getMailHost(), sender.getMail(), sender.getPassWord());
            //计算连接邮件服务器时间
//            long temp3 = System.currentTimeMillis();
//            System.out.println("connect Host"+(temp3 - temp2));

//            ts.sendMessage(msg, msg.getAllRecipients());
            ts.send(msg);
            //计算发送所消耗时间
//            long end = System.currentTimeMillis();
//            System.out.println("send "+(end - temp3));
            ts.close();
        } else {
            throw new NullPointerException("发件人不能为空");
        }
    }

    private Message createMessage(Session session) throws IOException, MessagingException, TemplateException {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender.getMail(), sender.getPersonal(), Global.UTF8));
        //添加收件人、抄送、密件抄送
        setRecipients(msg);
        //不存在图片邮件正文
        setMailContext(msg);
        if (getImages() != null) {
            //如果正文为html且需要图片，添加图片
            setMailImges(msg);
        }
        if (getAttachments() != null) {
            //需要发送附件，添加附件
            setMailAttachments(msg);
        }
        return msg;
    }

    private void setMailAttachments(Message msg) throws IOException, MessagingException {
        MimeMultipart multipart = new MimeMultipart("mixed");
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.setContent((MimeMultipart)msg.getContent());
        multipart.addBodyPart(attachmentBodyPart);
        for (Attachment attachment: getAttachments()) {
            attachmentBodyPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(attachment.getFileLoction());
            attachmentBodyPart.setDataHandler(new DataHandler(fileDataSource));
            if (attachment.getFileName() != null && attachment.getFileName().trim() != "") {
                attachmentBodyPart.setFileName(attachment.getFileName());
            } else {
                attachmentBodyPart.setFileName(fileDataSource.getName());
            }
            multipart.addBodyPart(attachmentBodyPart);
            fileDataSource = null;
            attachmentBodyPart = null;
        }
        msg.setContent(multipart);

    }

    private void setMailImges(Message msg) throws IOException, TemplateException, MessagingException {
//        MimeMessage message = (MimeMessage) msg;

        MimeMultipart multipart = new MimeMultipart("related");

        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        String htmlText = getMailBody().getBody();
//        System.out.println(htmlText+"\n\n\n\n"+getMailBody().getType());
//        messageBodyPart.setContent(htmlText, getMailBody().getType());

        messageBodyPart.setContent((MimeMultipart)msg.getContent());

        multipart.addBodyPart(messageBodyPart);

        for (Image image: getImages()) {
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(image.getImgPath());
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setContentID(image.getImgCid());
            multipart.addBodyPart(messageBodyPart);
            fds = null;
            messageBodyPart = null;
        }

        msg.setContent(multipart);
    }

    private void setMailContext(Message msg) throws MessagingException, IOException, TemplateException {
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = getMailBody().getBody();
        messageBodyPart.setContent(htmlText, getMailBody().getType());
        multipart.addBodyPart(messageBodyPart);
//        System.out.println(htmlText);
        msg.setSubject(getMailBody().getSubject());
        msg.setSentDate(new Date());
        msg.setContent(multipart);
    }

    private void setRecipients(Message msg) throws UnsupportedEncodingException, MessagingException {
        if (getReceivers() != null) {
            setReceiver(msg, Message.RecipientType.TO, getReceivers(), Global.UTF8);
        }
        if (getCarbonCopys() != null) {
            setReceiver(msg, Message.RecipientType.CC, getCarbonCopys(), Global.UTF8);
        }
        if (getBlindCarbonCopys() != null) {
            setReceiver(msg, Message.RecipientType.BCC, getBlindCarbonCopys(), Global.UTF8);
        }
    }

    private void setReceiver(Message msg, Message.RecipientType type, List<Receiver> receivers, String utf8) throws UnsupportedEncodingException, MessagingException {
        for ( Receiver receiver: receivers) {
            msg.addRecipient(type, new InternetAddress(receiver.getMail(), receiver.getPersonal(), utf8));
        }
    }

    private Session createSession(String protol) {
        Properties props = properties.getProps();
        props.put("mail.smtp.host", sender.getMailHost());
        props.put("mail.smtp.port", sender.getHostPort());
        props.setProperty("mail.transport.protocol", Protol.SMTP.getProtol());
        Authenticator authenticator = new MailAuthenticator(sender.getMail(),sender.getPassWord());
        Session session = Session.getDefaultInstance(props,authenticator);
        return session;
    }


    /**
     * 添加发件人
     * @param sender
     * @return
     */
    public JavaMail addSender(Sender sender) {
        if (sender != null){
            this.sender = sender;
        } else {
            throw new NullPointerException("sender 为空");
        }
        return this;
    }

    /**
     * 添加收件人
     * @param receiver
     * @return
     */
    public JavaMail addReceiver(Receiver receiver){
        if (receiver != null) {
            synchronized (getInitReceivers()) {
                this.receivers.add(receiver);
            }
        } else {
            throw new NullPointerException("receiver 为空");
        }
        return this;
    }

    public JavaMail addReceiverList(List<Receiver> receiverList){
        if (receiverList != null) {
            for (Receiver receiver:receiverList) {
                addReceiver(receiver);
            }
        } else {
            throw new NullPointerException("receiverList 为空");
        }
        return this;
    }

    /**
     * 添加 抄送
     * @param carbonCopy
     * @return
     */
    public JavaMail addCarbonCopy(Receiver carbonCopy){
        if (carbonCopy != null) {
            synchronized (getInitCarbonCopys()) {
                this.carbonCopys.add(carbonCopy);
            }
        } else {
            throw new NullPointerException("carbonCopy 为空");
        }
        return this;
    }

    public JavaMail addCarbonCopyList(List<Receiver> carbonCopyList){
        if (carbonCopyList != null) {
            for (Receiver receiver:carbonCopyList) {
                addCarbonCopy(receiver);
            }
        } else {
            throw new NullPointerException("carbonCopyList 为空");
        }
        return this;
    }

    /**
     * 添加秘密邮件收件人
     * @param blindCarbonCopy
     * @return
     */
    public JavaMail addBlindCarbonCopy(Receiver blindCarbonCopy){
        if (blindCarbonCopy != null) {
            synchronized (getInitBlindCarbonCopys()) {
                this.blindCarbonCopys.add(blindCarbonCopy);
            }
        } else {
            throw new NullPointerException("blindCarbonCopy 为空");
        }
        return this;
    }

    public JavaMail addBlindCarbonCopyList(List<Receiver> blindCarbonCopyList){
        if (blindCarbonCopyList != null) {
            for (Receiver receiver:blindCarbonCopyList) {
                addBlindCarbonCopy(receiver);
            }
        } else {
            throw new NullPointerException("blindCarbonCopyList 为空");
        }
        return this;
    }

    /**
     * 添加正文
     * @param body
     * @return
     */
    public JavaMail addBody(MailBody body) {
        if (body != null) {
            this.mailBody = body;
        } else {
            throw new NullPointerException("body 为空");
        }
        return this;
    }

    /**
     * 添加图片
     * @param image
     * @return
     */
    public JavaMail addImg(Image image){
        if (image != null) {
            synchronized (getInitImgs()) {
                this.images.add(image);
            }
        } else {
            throw new NullPointerException("image 为空");
        }
        return this;
    }

    public JavaMail addImgList(List<Image> imageList){
        if (imageList != null) {
            for (Image image:imageList) {
                addImg(image);
            }
        } else {
            throw new NullPointerException("imageList 为空");
        }
        return this;
    }

    /**
     * 添加附件
     * @param attachment
     * @return
     */
    public JavaMail addAttachment(Attachment attachment){
        if (attachment != null) {
            synchronized (getInitAttachments()) {
                this.attachments.add(attachment);
            }
        } else {
            throw new NullPointerException("attachment 为空");
        }
        return this;
    }

    public JavaMail addAttachmentList(List<Attachment> attachmentList){
        if (attachmentList != null) {
            for (Attachment attachment:attachmentList) {
                addAttachment(attachment);
            }
        } else {
            throw new NullPointerException("attachmentList 为空");
        }
        return this;
    }
    public JavaMail addProperties(MailProperties properties) {
        if (properties != null) {
            this.properties = properties;
        } else {
            throw new NullPointerException("properties 为空");
        }
        return this;
    }
    /**
     * 邮件发送方
     */
    private Sender sender;
    /**
     * 邮件接收方
     */
    private List<Receiver> receivers;
    /**
     * 邮件抄送
     */
    private List<Receiver> carbonCopys;
    /**
     * 邮件密件抄送
     */
    private List<Receiver> blindCarbonCopys;

    /**
     * 邮件正文（String、html）
     */
    private MailBody mailBody;
    /**
     * 邮件正文中含有图片
     */
    private List<Image> images;
    /**
     * 邮件附件
     */
    private List<Attachment> attachments;

    /**
     * 邮件发送配置属性
     */
    MailProperties properties;
    /** GET SET **/

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public List<Receiver> getCarbonCopys() {
        return carbonCopys;
    }

    public void setCarbonCopys(List<Receiver> carbonCopys) {
        this.carbonCopys = carbonCopys;
    }

    public List<Receiver> getBlindCarbonCopys() {
        return blindCarbonCopys;
    }

    public void setBlindCarbonCopys(List<Receiver> blindCarbonCopys) {
        this.blindCarbonCopys = blindCarbonCopys;
    }

    public MailBody getMailBody() {
        return mailBody;
    }

    public void setMailBody(MailBody mailBody) {
        this.mailBody = mailBody;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public MailProperties getProperties() {
        return properties;
    }

    public void setProperties(MailProperties properties) {
        this.properties = properties;
    }

    private synchronized List<Receiver> getInitReceivers() {
        if (this.receivers == null) {
            this.receivers = new ArrayList<>();
        }
        return this.receivers;
    }
    private synchronized List<Receiver> getInitCarbonCopys() {
        if (this.carbonCopys == null) {
            this.carbonCopys = new ArrayList<>();
        }
        return this.carbonCopys;
    }
    private synchronized List<Receiver> getInitBlindCarbonCopys() {
        if (this.blindCarbonCopys == null) {
            this.blindCarbonCopys =  new ArrayList<>();
        }
        return this.blindCarbonCopys;

    }
    private synchronized List<Image> getInitImgs() {
        if (this.images == null) {
            this.images = new ArrayList<>();
        }
        return this.images;
    }
    private synchronized List<Attachment> getInitAttachments() {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        return this.attachments;
    }
}
