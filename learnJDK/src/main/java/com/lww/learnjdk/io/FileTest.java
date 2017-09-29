package com.lww.learnjdk.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lww on 2017/9/25.
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        String filePath = "A:/Java/File/test.dad";
        FileUtils utils = new FileUtils();
        File file = utils.newFile(filePath);

//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsolutePath());

//        Date date = new Date(file.lastModified());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String da = format.format(date);
//        System.out.println(da);
//
//
//        System.out.println(file.length());
//        System.out.println(file.listRoots());
//        System.out.println(file.listFiles());



//        if (!dir.exists()) {
//            dir.mkdirs();
//            System.out.println(dir.mkdir());
//        }
//        String[] str=dir.list();
//        File[] str1=dir.listFiles();
//        System.out.println("lastModified():"+ new Date(dir.lastModified()));
//        System.out.println("length():"+dir.length()+"\ngetAbsolutePath:"+dir.getAbsolutePath());
//        System.out.println("getPath:"+dir.getPath());
//        System.out.println("getName:"+dir.getName()+"\ngetParent:"+dir.getParent());
//        for(int j=0;j<str1.length;j++)
//            System.out.println(":"+str1[j]);
//        for(int i=0;i<str.length;i++)
//        {
//            System.out.println(":"+str[i]);
//        }
    }
}
