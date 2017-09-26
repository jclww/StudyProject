package com.lww.learnjdk.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lww on 2017/9/25.
 */
public class FileUtils {
    public File newFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } else {
            System.out.println("文件已经存在");
        }
        return file;
    }

    public File newDirectory(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            System.out.println("文件夹已经存在");
        }
        return file;
    }
}
