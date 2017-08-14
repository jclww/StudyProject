package com.lww.ledis.util;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * Created by lenovo on 2017/7/27.
 */
public class HostAndPort implements Serializable {
    private static final long serialVersionUID = -519876229978427751L;

//    protected static Logger log = Logger.getLogger(HostAndPort.class.getName());
    public static final String LOCALHOST_STR = getLocalHostQuietly();


    private String host;
    private int port;

    public HostAndPort(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
    public static String[] extractParts(String from){
        int idx     = from.lastIndexOf(":");
        String host = idx != -1 ? from.substring(0, idx)  : from;
        String port = idx != -1 ? from.substring(idx + 1) : "";
        return new String[] { host, port };
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HostAndPort) {
            HostAndPort hp = (HostAndPort) obj;

            String thisHost = convertHost(host);
            String hpHost = convertHost(hp.host);
            return port == hp.port && thisHost.equals(hpHost);

        }

        return false;
    }

    @Override
    public int hashCode() {
        return 31 * convertHost(host).hashCode() + port;
    }
    public static String convertHost(String host) {
        if (host.equals("127.0.0.1") || host.startsWith("localhost") || host.equals("0.0.0.0") ||
                host.startsWith("169.254") ||
                host.startsWith("::1") || host.startsWith("0:0:0:0:0:0:0:1")) {
            return LOCALHOST_STR;
        } else {
            return host;
        }
    }
    @Override
    public String toString() {
        return host + ":" + port;
    }
    public static String getLocalHostQuietly() {
        String localAddress;
        try {
            localAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
//            log.logp(Level.SEVERE, HostAndPort.class.getName(), "getLocalHostQuietly", "cant resolve localhost address", ex);
            localAddress = "localhost";
        }
        return localAddress;
    }
}