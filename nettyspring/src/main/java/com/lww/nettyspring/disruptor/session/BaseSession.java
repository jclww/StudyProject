package com.lww.nettyspring.disruptor.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;

/**
 * Created by lenovo on 2017/8/23.
 */
public interface BaseSession extends AutoCloseable {

    /**
     * Get the netty's channel
     *
     * @return return netty's channel
     */
    Channel channel();

    /**
     * Is session is active
     *
     * @return Return true if the session is active. otherwise false.
     */
    boolean isActive();

    /**
     * Get the player
     *
     * @return Return player
     */
    Connector getConnector();

    /**
     * Set {@link Connector}. After player login, should set the player.
     *
     * @param connector The player
     */
    void setConnector(Connector connector);

    /**
     * Send message back without listener.
     *
     * @param msg The message will be send
     */
    void writeAndFlush(Object msg);

    /**
     * Send message back with listener.
     *
     * @param message The message will be send
     */
    void writeAndFlush(Object message, ChannelFutureListener listener);

    /**
     * the session active event. When the netty channel active.
     * the session will be trigger active event.
     */
    void active();

    /**
     * the session inactive event.When the netty channel inactive.
     * the session will be trigger inactive event.
     */
    void inactive();

    /**
     * when player logout, call this method to clear player data.
     */
    void offline();

    /**
     * Close netty's channel.
     */
    void close();
}

