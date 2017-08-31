package test.netty.services.connect;

import com.hiveview.netty.initializer.DomyServicesChannelInitializer;
import com.hiveview.protobuf.DomyReqMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Lww on 2017/8/25.
 */
public class DomyNettyConnect {
    private final String DEFAULT_HOST = "localhost";
    private final int DEFAULT_PORT = 8888;
    private int port;
    private String host;
    private Channel channel;
    private ChannelFuture f;

    public DomyNettyConnect(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public DomyNettyConnect(int port) {
        new DomyNettyConnect(DEFAULT_HOST, port);
    }
    public DomyNettyConnect(String host) {
        new DomyNettyConnect(host, DEFAULT_PORT);
    }
    public DomyNettyConnect() {
        new DomyNettyConnect(DEFAULT_HOST, DEFAULT_PORT);
    }

    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new DomyServicesChannelInitializer());
            channel = b.connect(host, port).sync().channel();
            // 当代客户端链路关闭
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }
    public void sendMessage(DomyReqMessage.DomyRequest.Builder req) {
        if (channel == null && channel.isActive()) {
            channel.writeAndFlush(req);
        }
        else {
            System.out.println("您与服务器已经断开连接！！");
        }
    }
}
