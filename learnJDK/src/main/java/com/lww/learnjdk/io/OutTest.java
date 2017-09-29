package com.lww.learnjdk.io;

import java.io.*;

/**
 * Created by Lww on 2017/9/21.
 */
public class OutTest {
    public static void main(String[] args) throws IOException {



        String fileName = "A:/Java/io/test.lww";
        File file = new File(fileName);
        if (file.isDirectory()) {
            System.out.println("文件夹");
        }
        if (file.isFile()) {
            System.out.println("文件");
        }
        if(!file.getParentFile().exists()){
            //创建文件夹
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //如果有文件夹就直接创建文件
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out.write("1231231asdsada李薇薇\r\n".getBytes());
            out.write("asdsadal阿萨德撒".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
