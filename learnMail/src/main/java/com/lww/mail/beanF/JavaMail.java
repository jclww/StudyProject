package com.lww.mail.beanF;

import java.util.ArrayList;
import java.util.List;

public class JavaMail {

    public JavaMail() {

    }

    public JavaMail(Sender sender) {
        this.sender = sender;
    }


    

    /**
     * 添加发件人
     * @param sender
     * @return
     */
    public JavaMail addSender(Sender sender) {
        if (sender != null){
            synchronized (this.sender) {
                this.sender = sender;
            }
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
            synchronized (this.receivers) {
                if (this.receivers == null) {
                    this.receivers = new ArrayList<>();
                }
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
            synchronized (this.carbonCopys) {
                if (this.carbonCopys == null) {
                    this.carbonCopys = new ArrayList<>();
                }
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
            synchronized (this.blindCarbonCopys) {
                if (this.blindCarbonCopys == null) {
                    this.blindCarbonCopys = new ArrayList<>();
                }
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
            synchronized (this.images) {
                if (this.images == null) {
                    this.images = new ArrayList<>();
                }
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
            synchronized (this.attachments) {
                if (this.attachments == null) {
                    this.attachments = new ArrayList<>();
                }
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
}
