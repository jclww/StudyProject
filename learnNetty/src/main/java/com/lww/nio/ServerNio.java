package com.lww.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by lenovo on 2017/8/18.
 */
public class ServerNio
{
    public static String GREETING = "Hello World\r\n";

    public static void main(String[] args)throws Exception
    {
        int port = 1234;
        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while(true) {
            System.out.println("waiting for connecting....");
            SocketChannel sc = ssc.accept();
            if(null == sc) {
                Thread.sleep(3000);
            } else {
                System.out.println("Incoming connecting from : "+sc.socket().getRemoteSocketAddress());
                sc.write(buffer);
                sc.close();
            }
        }
    }
}