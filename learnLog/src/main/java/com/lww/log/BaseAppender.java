package com.lww.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import com.alibaba.fastjson.JSONObject;
import com.lww.log.entity.LogData;
import com.lww.log.entity.LogDataDetail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseAppender extends AppenderBase<ILoggingEvent> {

    private static int poolSize = 2;

    private static ThreadPoolExecutor executors = new ThreadPoolExecutor(poolSize, 2 * poolSize, 10, TimeUnit
            .SECONDS, new ArrayBlockingQueue<>(5000), new ThreadPoolExecutor.DiscardPolicy());

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executors.shutdown();
        }));
    }

    //日志最大长度,发送默认加换行,所以长度-1
    private static final int LOG_MAX_SIZE = 64 * 1024 - 1;
    //上报TopN错误字段msg分隔符
    private static final String SEPARATOR = "\001A";

    protected String app;

    protected String server = "unknown.host/0.0.0.0";

    @Override
    public void start() {
        try {
            server = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            throw new RuntimeException("appender start failed", e);
        }
        super.start();

    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        String level = eventObject.getLevel().toString().toLowerCase();
        if (!level.equals("warn") && !level.equals("error")) {
            return;
        }

        String body = "Server:" + server + "\nbody:" + buildBody(eventObject);


        if (body.length() >= LOG_MAX_SIZE) {
            return;
        }
        executors.submit(new MailSendTask(body));

    }

    private String buildBody(ILoggingEvent eventObject) {
        String level = eventObject.getLevel().toString().toLowerCase();

        LogData logData = new LogData();
        logData.setApp(app);
        logData.setLevel(level);
        logData.setModule(eventObject.getLoggerName());


        LogDataDetail detail = new LogDataDetail();
        //用于错误统计TopN
        StringBuilder msg = new StringBuilder();
        msg.append("level:").append(level).append("\n");
        msg.append("message:").append(eventObject.getMessage()).append("\n");


        IThrowableProxy proxy = eventObject.getThrowableProxy();
        if (proxy != null) {
            LogError error = new LogError(proxy);
            detail.setError(error);
        }

        Object[] args = eventObject.getArgumentArray();
        if (args != null) {
            int length = args.length;
            if (length > 0) {
                for (Object arg : args) {
                    if (arg instanceof Throwable) {
                        detail.setError(new LogError((Throwable) arg));
                        break;
                    }
                }
                if (args[length - 1] instanceof Map) {
                    detail.setExtra(args[length - 1]);
                }
            }
        }


        if (level.contains("warn") || level.equals("error")) {
            HashMap extraMap = ((HashMap) detail.getExtra());
            msg.append("service:");
            msg = extraMap != null && extraMap.get("service") != null ? msg.append(extraMap.get("service")) : msg.append(getService(eventObject));
            msg.append("\n");
            msg.append("method:");
            msg = extraMap != null && extraMap.get("method") != null ? msg.append(extraMap.get("method")) : msg.append(getMethod(eventObject));
            msg.append("\n");
            msg.append("code:");
            msg = extraMap != null && extraMap.get("code") != null ? msg.append(extraMap.get("code")) : msg;
            msg.append("\n");
            detail.setLogStatisticsField(msg.toString());
        }

        logData.setDetail(detail);

        String json = JSONObject.toJSONString(logData);

        return json;
    }

    public static boolean checkParamIllegal(String s, String whiteList) {
        if (s == null || s.length() == 0) {
            return false;
        }
        byte[] bytes = s.getBytes();
        byte[] whiteListBytes = whiteList == null ? null : whiteList.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (!isLowerCaseAlphaNumeric(b) && !isInSpecifiedBytes(b, whiteListBytes)) {
                return false;
            }
        }
        return true;
    }

    private static String getService(ILoggingEvent eventObject) {
        if (eventObject == null || eventObject.getCallerData() == null || eventObject.getCallerData().length < 1) {
            return null;
        }
        return eventObject.getCallerData()[0].getClassName();
    }

    private static String getMethod(ILoggingEvent eventObject) {
        if (eventObject == null || eventObject.getCallerData() == null || eventObject.getCallerData().length < 1) {
            return null;
        }
        return eventObject.getCallerData()[0].getMethodName();
    }

    private static boolean isInSpecifiedBytes(byte b, byte[] bytes) {
        if (bytes == null) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (b == bytes[i]) {
                return true;
            }
        }
        return false;
    }


    private static boolean isLowerCaseAlphaNumeric(byte b) {
        return isLowerCaseAlpha(b) || isNumeric(b);
    }

    private static boolean isLowerCaseAlpha(byte b) {
        return b > 96 && b < 123;
    }

    private static boolean isNumeric(byte b) {
        return b > 47 && b < 58;
    }


    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}