package com.lww.learnjdk.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 单连接 只接收数据的服务端
 */
public class BioServer {

    private static Integer port = 10086;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream in = null;
        try {
            serverSocket = new ServerSocket(port);
            int receiveMsgSize = 0;
            byte[] receiveBuf = new byte[1024];
            while (true) {
                Socket clntSocket = serverSocket.accept();
                System.out.println("Handling client at " + clntSocket.getRemoteSocketAddress());
                in = clntSocket.getInputStream();

                while ((receiveMsgSize = in.read(receiveBuf)) != -1) {
                    byte[] temp = new byte[receiveMsgSize];
                    System.arraycopy(receiveBuf, 0, temp, 0, receiveMsgSize);
                    System.out.println(Arrays.toString(temp));
                    System.out.println(new String(temp));
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
