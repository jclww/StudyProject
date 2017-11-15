package com.lww.learn.zxing;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lww on 2017/11/13.
 */
public class QRTest {
    public static void main(String[] args) throws IOException, WriterException {
        testEncode();
    }
    public static void testEncode() throws WriterException, IOException {
        String content="我爱你";
        String logUri="A:\\Java\\qr\\log.jpg";
        String outFileUri="A:\\Java\\qr\\test2.jpg";
        int[]  size=new int[]{430,430};
        String format = "jpg";

        try {
            new QRCodeFactory().CreatQrImage(content, format, outFileUri, logUri,size);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
