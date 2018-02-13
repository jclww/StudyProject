package com.lww.learnFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileUpload {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/liweiwei/Java/test");
        if (file1.exists()) {
            file1.delete();
        }
        file1.setWritable(true);

        File file2 = new File("/Users/liweiwei/Date/0211updateUnbindTime.txt");


        copyFile(file2,file1);
        Runtime.getRuntime().exec("chmod 777 " + "/Users/liweiwei/Java/test");

//        /Users/liweiwei/Date/0211updateUnbindTime.txt
    }
    public static void copyFile(File fromFile,File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1) {
            out.write(b, 0, n);
        }

        ins.close();
        out.close();
    }
}
