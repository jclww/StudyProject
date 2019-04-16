package com.lww.learnjdk.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 将获取到数据返回client
 */
public class BioServer2 {

    private static Integer port = 10086;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(port);
            int receiveMsgSize = 0;
            byte[] receiveBuf = new byte[1024];
            while (true) {
                Socket clntSocket = serverSocket.accept();
                System.out.println("Handling client at " + clntSocket.getRemoteSocketAddress());
                in = clntSocket.getInputStream();
                out = clntSocket.getOutputStream();

                while ((receiveMsgSize = in.read(receiveBuf)) != -1) {
                    byte[] temp = new byte[receiveMsgSize];
                    System.arraycopy(receiveBuf, 0, temp, 0, receiveMsgSize);
                    System.out.println(Arrays.toString(temp));
                    System.out.println(new String(temp));
                    // 循环发送数据
//                    out.write(temp);
//                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
