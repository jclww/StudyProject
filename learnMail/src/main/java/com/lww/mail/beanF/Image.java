package com.lww.mail.beanF;

public class Image {
    private String imgCid;
    private String imgPath;

    public Image(String imgCid, String imgPath) {
        this.imgCid = imgCid;
        this.imgPath = imgPath;
    }

    /** GET SET **/

    public String getImgCid() {
        return imgCid;
    }

    public void setImgCid(String imgCid) {
        this.imgCid = imgCid;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
