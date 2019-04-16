package com.lww.learnjdk.io.bio;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 获取服务端的返回数据
 */
public class BioClient2 {
    private static String host = "127.0.0.1";
    private static Integer port = 10086;


    public static void main(String[] args) {
        byte[] data = getData();
        Socket client = null;
        OutputStream out = null;
        InputStream inputStream = null;

        try {
            client = new Socket(host, port);
//            client.setSoTimeout(10000);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            out = client.getOutputStream();
            out.write(data);
            out.flush();

            inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            int receiveMsgSize = 0;
            byte[] receiveBuf = new byte[1024];

            while ((receiveMsgSize = dataInputStream.read(receiveBuf)) != -1) {
                byte[] temp = new byte[receiveMsgSize];
                System.arraycopy(receiveBuf, 0, temp, 0, receiveMsgSize);
                System.out.println(Arrays.toString(temp));
                System.out.println(new String(temp));
                out.write(temp);
                out.flush();
            }

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
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getData() {
        String data = "你好";

        return data.getBytes(Charset.forName("UTF-8"));
    }
}
