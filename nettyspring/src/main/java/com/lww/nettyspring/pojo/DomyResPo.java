package com.lww.nettyspring.pojo;

/**
 * Created by lenovo on 2017/8/21.
 */
public class DomyResPo {
    private Integer type; //请求类型
    private String mac;   //mac地址
    private String sn;    //sn

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
}
