package com.lww.learnjdk.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Lww on 2017/10/17.
 */
public class IOServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream in = null;
        try
        {
            serverSocket = new ServerSocket(10086);
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            System.out.println("1111");
            while(true){
                Socket clntSocket = serverSocket.accept();
                System.out.println("呃呃呃额额");
                SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clientAddress);
                in = clntSocket.getInputStream();
                while((recvMsgSize=in.read(recvBuf))!=-1){
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
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
