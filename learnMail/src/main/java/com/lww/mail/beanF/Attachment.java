package com.lww.mail.beanF;

public class Attachment {
    private String fileName;
    private String fileLoction;

    public Attachment(String fileName, String fileLoction) {
        this.fileName = fileName;
        this.fileLoction = fileLoction;
    }

    /** GET SET **/
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLoction() {
        return fileLoction;
    }

    public void setFileLoction(String fileLoction) {
        this.fileLoction = fileLoction;
    }
}
