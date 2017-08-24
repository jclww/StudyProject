package com.lww.nettyspring.disruptor.session;


/**
 * Created by lenovo on 2017/8/23.
 */
public interface Connector<S extends BaseSession> {

    /**
     * Is the player online
     *
     * @return Return true if the session is connected and channel is active. otherwise false.
     */
    boolean isOnline();

    /**
     * Get the player's session
     *
     * @return Return player's session
     */
    S session();

    /**
     * Set player's session. After player's login operation, should set call this function to set session.
     *
     * @param session The session for player
     */
    void setSession(S session);

    /**
     * After player create connection and connected.
     */
    void sessionActive();

    /**
     * When the player lost connection to server. System will call this function.
     */
    void sessionInactive();
}