package com.lww.mail.beanF;

public class Attachment {
    private String fileName;
    private String fileLoction;

    public Attachment(String fileLoction) {
        this(fileLoction,null);
    }

    public Attachment(String fileLoction, String fileName) {
        this.fileLoction = fileLoction;
        this.fileName = fileName;
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
