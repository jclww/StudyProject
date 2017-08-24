package com.hiveview.netty.pojo;

/**
 * Created by Lww on 2017/8/24.
 */
public class DomyReqPo {
    /**
     * type
     * 1 : 登录
     * 2 : 客户端消息
     * 3 : 服务器推送消息
     */
    private Integer type; //请求类型
    private String mac;   //mac地址
    private String sn;    //sn
    private String messageBody;//消息体 具体的命令在这个 json字符串中进行传递

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}