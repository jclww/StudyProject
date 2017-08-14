package com.lww.ledis.connection;

import com.lww.ledis.exception.LedisConnectionException;
import com.lww.ledis.global.GlobalCommand;
import com.lww.ledis.protocol.LedisInputStream;
import com.lww.ledis.protocol.LedisOutputStream;
import com.lww.ledis.protocol.RedisProtocol;
import com.lww.ledis.util.SafeEncoder;
import redis.clients.jedis.BuilderFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

/**
 * Created by Lww on 2017/7/26.
 */
public class Connection implements Closeable {
    private static final byte[][] EMPTY_ARGS = new byte[0][];
    private String host = "localhost";
    private int port = 6379;
    private Socket socket;
    private LedisOutputStream outputStream;
    private LedisInputStream inputStream;
    private int pipelinedCommands = 0;
    private int connectionTimeout = 2000;
    private int soTimeout = 2000;
    private boolean broken = false;
    private boolean ssl;
    private SSLSocketFactory sslSocketFactory;
    private SSLParameters sslParameters;
    private HostnameVerifier hostnameVerifier;
    public Socket getSocket() {
        return this.socket;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }
    public Connection() {
    }
    public Connection(final String host) {
        this.host = host;
    }
    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection(String host, int port, boolean ssl) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
    }

    public Connection(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.sslSocketFactory = sslSocketFactory;
        this.sslParameters = sslParameters;
        this.hostnameVerifier = hostnameVerifier;
    }
    protected Connection sendCommand(GlobalCommand cmd, String... args) {
        byte[][] bargs = new byte[args.length][];

        for(int i = 0; i < args.length; ++i) {
            bargs[i] = SafeEncoder.encode(args[i]);
        }

        return this.sendCommand(cmd, bargs);
    }

    protected Connection sendCommand(GlobalCommand cmd) {
        return this.sendCommand(cmd, EMPTY_ARGS);
    }

    protected Connection sendCommand(GlobalCommand cmd, byte[]... args) {
        try {
            this.connect();
            RedisProtocol.sendCommand(this.outputStream, cmd, args);
            ++this.pipelinedCommands;
            return this;
        } catch (LedisConnectionException var6) {
            LedisConnectionException ex = var6;

            try {
                String errorMessage = RedisProtocol.readErrorLineIfPossible(this.inputStream);
                if(errorMessage != null && errorMessage.length() > 0) {
                    ex = new LedisConnectionException(errorMessage, ex.getCause());
                }
            } catch (Exception var5) {
            }

            this.broken = true;
            throw ex;
        }
    }
    public void connect() {
        if(!this.isConnected()) {
            try {
                this.socket = new Socket();
                this.socket.setReuseAddress(true);
                this.socket.setKeepAlive(true);
                this.socket.setTcpNoDelay(true);
                this.socket.setSoLinger(true, 0);
                this.socket.connect(new InetSocketAddress(this.host, this.port), this.connectionTimeout);
                this.socket.setSoTimeout(this.soTimeout);
                if(this.ssl) {
                    if(null == this.sslSocketFactory) {
                        this.sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
                    }

                    this.socket = (SSLSocket)this.sslSocketFactory.createSocket(this.socket, this.host, this.port, true);
                    if(null != this.sslParameters) {
                        ((SSLSocket)this.socket).setSSLParameters(this.sslParameters);
                    }

                    if(null != this.hostnameVerifier && !this.hostnameVerifier.verify(this.host, ((SSLSocket)this.socket).getSession())) {
                        String message = String.format("The connection to '%s' failed ssl/tls hostname verification.", new Object[]{this.host});
                        throw new LedisConnectionException(message);
                    }
                }
                this.outputStream = new LedisOutputStream(this.socket.getOutputStream());
                this.inputStream = new LedisInputStream(this.socket.getInputStream());
            } catch (IOException var2) {
                this.broken = true;
                throw new LedisConnectionException(var2);
            }
        }
    }
    public String getStatusCodeReply() {
        flush();
        pipelinedCommands--;
        final byte[] resp = (byte[]) readProtocolWithCheckingBroken();
        if (null == resp) {
            return null;
        } else {
            return SafeEncoder.encode(resp);
        }
    }
    protected void flush() {
        try {
            outputStream.flush();
        } catch (IOException ex) {
            broken = true;
            throw new LedisConnectionException(ex);
        }
    }
    protected Object readProtocolWithCheckingBroken() {
        try {
            return RedisProtocol.read(inputStream);
        } catch (LedisConnectionException exc) {
            broken = true;
            throw exc;
        }
    }
    public void close() {
        this.disconnect();
    }
    public void disconnect() {
        if(this.isConnected()) {
            try {
                this.outputStream.flush();
                this.socket.close();
            } catch (IOException var5) {
                this.broken = true;
                throw new LedisConnectionException(var5);
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // ignored
                    }
                }
            }
        }
    }
    public boolean isConnected() {
        return this.socket != null && this.socket.isBound() && !this.socket.isClosed() && this.socket.isConnected() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }
    public Long getIntegerReply() {
        flush();
        pipelinedCommands--;
        return (Long) readProtocolWithCheckingBroken();
    }
    public byte[] getBinaryBulkReply() {
        flush();
        pipelinedCommands--;
        return (byte[]) readProtocolWithCheckingBroken();
    }
    public String getBulkReply() {
        final byte[] result = getBinaryBulkReply();
        if (null != result) {
            return SafeEncoder.encode(result);
        } else {
            return null;
        }
    }
    public List<String> getMultiBulkReply() {
        return BuilderFactory.STRING_LIST.build(getBinaryMultiBulkReply());
    }
    @SuppressWarnings("unchecked")
    public List<byte[]> getBinaryMultiBulkReply() {
        flush();
        pipelinedCommands--;
        return (List<byte[]>) readProtocolWithCheckingBroken();
    }
}
