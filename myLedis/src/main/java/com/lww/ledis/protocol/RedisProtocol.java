package com.lww.ledis.protocol;

import com.lww.ledis.exception.*;
import com.lww.ledis.global.GlobalCommand;
import com.lww.ledis.global.GlobalValue;
import com.lww.ledis.util.HostAndPort;
import com.lww.ledis.util.SafeEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lww on 2017/7/26.
 */
public final class RedisProtocol {
    /**
     * Redis协议
     * 消息头部
     * 参考http://www.cnblogs.com/smark/p/3247620.html
     */
    public static final byte DOLLAR_BYTE = '$';    //表示下一行数据长度，不包括换行符长度\r\n,$后面则是对应的长度的数据。
    public static final byte ASTERISK_BYTE = '*';  //表示消息体总共有多少行，不包括当前行,*后面是具体的行数。
    public static final byte PLUS_BYTE = '+';      //表示一个正确的状态信息，具体信息是当前行+后面的字符。
    public static final byte MINUS_BYTE = '-';     //表示一个错误信息，具体信息是当前行－后面的字符。
    public static final byte COLON_BYTE = ':';     //表示返回一个数值，：后面是相应的数字节符。

    public static final String DEFAULT_HOST = "localhost";  //默认服务器地址
    public static final int DEFAULT_PORT = 6379;            //默认服务器端口
    public static final String CHARSET = "UTF-8";           //编码


    private static final String ASK_RESPONSE = "ASK";
    private static final String MOVED_RESPONSE = "MOVED";
    private static final String CLUSTERDOWN_RESPONSE = "CLUSTERDOWN";
    private static final String BUSY_RESPONSE = "BUSY";
    private static final String NOSCRIPT_RESPONSE = "NOSCRIPT";

    public static void sendCommand(final LedisOutputStream os, final GlobalCommand command,
                                   final byte[]... args) {
        sendCommand(os, command.raw, args);
    }

    private static void sendCommand(final LedisOutputStream os, final byte[] command,
                                    final byte[]... args) {
        try {
            os.write(ASTERISK_BYTE);
            os.writeIntCrLf(args.length + 1);
            os.write(DOLLAR_BYTE);
            os.writeIntCrLf(command.length);
            os.write(command);
            os.writeCrLf();

            for (final byte[] arg : args) {
                os.write(DOLLAR_BYTE);
                os.writeIntCrLf(arg.length);
                os.write(arg);
                os.writeCrLf();
            }
        } catch (IOException e) {
            throw new LedisConnectionException(e);
        }
    }
    public static String readErrorLineIfPossible(LedisInputStream is) {
        final byte b = is.readByte();
        // if buffer contains other type of response, just ignore.
        if (b != MINUS_BYTE) {
            return null;
        }
        return is.readLine();
    }

    private static String[] parseTargetHostAndSlot(String clusterRedirectResponse) {
        String[] response = new String[3];
        String[] messageInfo = clusterRedirectResponse.split(" ");
        String[] targetHostAndPort = HostAndPort.extractParts(messageInfo[2]);
        response[0] = messageInfo[1];
        response[1] = targetHostAndPort[0];
        response[2] = targetHostAndPort[1];
        return response;
    }
    public static Object read(final LedisInputStream is) {
        return process(is);
    }
    private static Object process(final LedisInputStream is) {

        final byte b = is.readByte();
        if (b == PLUS_BYTE) {
            return processStatusCodeReply(is);
        } else if (b == DOLLAR_BYTE) {
            return processBulkReply(is);
        } else if (b == ASTERISK_BYTE) {
            return processMultiBulkReply(is);
        } else if (b == COLON_BYTE) {
            return processInteger(is);
        } else if (b == MINUS_BYTE) {
            processError(is);
            return null;
        } else {
            throw new LedisConnectionException("Unknown reply: " + (char) b);
        }
    }
    private static byte[] processStatusCodeReply(final LedisInputStream is) {
        return is.readLineBytes();
    }

    private static byte[] processBulkReply(final LedisInputStream is) {
        final int len = is.readIntCrLf();
        if (len == -1) {
            return null;
        }

        final byte[] read = new byte[len];
        int offset = 0;
        while (offset < len) {
            final int size = is.read(read, offset, (len - offset));
            if (size == -1) throw new LedisConnectionException(
                    "It seems like server has closed the connection.");
            offset += size;
        }

        // read 2 more bytes for the command delimiter
        is.readByte();
        is.readByte();

        return read;
    }

    private static Long processInteger(final LedisInputStream is) {
        return is.readLongCrLf();
    }

    private static List<Object> processMultiBulkReply(final LedisInputStream is) {
        final int num = is.readIntCrLf();
        if (num == -1) {
            return null;
        }
        final List<Object> ret = new ArrayList<Object>(num);
        for (int i = 0; i < num; i++) {
            try {
                ret.add(process(is));
            } catch (LedisDataException e) {
                ret.add(e);
            }
        }
        return ret;
    }
    private static void processError(final LedisInputStream is) {
        String message = is.readLine();
        // TODO: I'm not sure if this is the best way to do this.
        // Maybe Read only first 5 bytes instead?
        if (message.startsWith(MOVED_RESPONSE)) {
            String[] movedInfo = parseTargetHostAndSlot(message);
            throw new LedisMovedDataException(message, new HostAndPort(movedInfo[1],
                    Integer.valueOf(movedInfo[2])), Integer.valueOf(movedInfo[0]));
        } else if (message.startsWith(ASK_RESPONSE)) {
            String[] askInfo = parseTargetHostAndSlot(message);
            throw new LedisAskDataException(message, new HostAndPort(askInfo[1],
                    Integer.valueOf(askInfo[2])), Integer.valueOf(askInfo[0]));
        } else if (message.startsWith(CLUSTERDOWN_RESPONSE)) {
            throw new LedisClusterException(message);
        } else if (message.startsWith(BUSY_RESPONSE)) {
            throw new LedisBusyException(message);
        } else if (message.startsWith(NOSCRIPT_RESPONSE) ) {
            throw new LedisNoScriptException(message);
        }
        throw new LedisDataException(message);
    }
    public static final byte[] toByteArray(final boolean value) {
        return value ? GlobalValue.BYTES_TRUE : GlobalValue.BYTES_FALSE;
    }

    public static final byte[] toByteArray(final int value) {
        return SafeEncoder.encode(String.valueOf(value));
    }

    public static final byte[] toByteArray(final long value) {
        return SafeEncoder.encode(String.valueOf(value));
    }

    public static final byte[] toByteArray(final double value) {
        if (Double.isInfinite(value)) {
            return value == Double.POSITIVE_INFINITY ? "+inf".getBytes() : "-inf".getBytes();
        }
        return SafeEncoder.encode(String.valueOf(value));
    }
}
