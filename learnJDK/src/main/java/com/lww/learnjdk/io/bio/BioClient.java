package com.lww.learnjdk.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Client 只传递数据
 */
public class BioClient {

    private static String host = "127.0.0.1";
    private static Integer port = 10086;


    public static void main(String[] args) {
        byte[] data = getData();
        Socket client = null;
        OutputStream out = null;
        try {
            client = new Socket(host, port);
//            client.setSoTimeout(10000);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            out = client.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getData() {
        String data = "Hello World";

        return data.getBytes(Charset.forName("UTF-8"));
    }
}
