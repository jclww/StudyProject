package com.lww.mail.send;

import com.lww.mail.MailProtol;
import com.lww.mail.enity.MailReceiver;
import com.lww.mail.enity.SendPlainMailBean;
import com.lww.mail.utils.Global;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

public class SendPlainMail extends AbStractSend implements SendMail<SendPlainMailBean> {


    public SendPlainMail() {
        super(MailProtol.SMTP.toString());
    }

    @Override
    public String sendMail(SendPlainMailBean mailBean) {
        Session session = getSession(mailBean);
        logger.info("-------开始发送-------");
        try {
            Message msg = creatMessage(session, mailBean);
            Transport ts = session.getTransport();
            ts.connect(mailBean.getHost(),mailBean.getUser(), mailBean.getPassWord());
            ts.send(msg);
            ts.close();
            logger.info("-------发送完成-------");
        } catch (AddressException e) {
            logger.error(e.getMessage());
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    protected Message creatMessage(Session session, SendPlainMailBean mailBean) throws UnsupportedEncodingException, MessagingException {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(mailBean.getUser(),mailBean.getFrom(), Global.UTF8));

        setRecipients(msg,mailBean);

        msg.setSubject(mailBean.getSubject());
        msg.setSentDate(new Date());
        msg.setContent(mailBean.getBody(),mailBean.getType());
        return msg;
    }

    protected void setRecipients(Message msg, SendPlainMailBean mailBean) throws UnsupportedEncodingException, MessagingException {
        if (mailBean.getReceives() != null) {
            setReceiver(msg, Message.RecipientType.TO,mailBean.getReceives(),Global.UTF8);
        }
        if (mailBean.getCarbonCopy() != null) {
            setReceiver(msg, Message.RecipientType.CC,mailBean.getCarbonCopy(),Global.UTF8);
        }
        if (mailBean.getBlindCarbonCopy() != null) {
            setReceiver(msg, Message.RecipientType.BCC,mailBean.getBlindCarbonCopy(),Global.UTF8);
        }
    }

    private void setReceiver(Message msg, Message.RecipientType to, List<MailReceiver> receivers, String utf8) throws UnsupportedEncodingException, MessagingException {
        for ( MailReceiver receiver: receivers) {
            msg.addRecipient(to, new InternetAddress(receiver.getMail(), receiver.getPersonal(), utf8));
        }
    }
}
