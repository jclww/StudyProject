package com.lww.log;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;

public class LogError {

    private int code;
    private String message;
    private String file;
    private int line;
    private Object param;
    private String stacktraces;

    public LogError() {

    }

    public LogError(Throwable t) {
        this.code = 500;
        this.message = t.getMessage();
        this.file = t.getStackTrace()[0].getFileName();
        this.line = t.getStackTrace()[0].getLineNumber();
        this.stacktraces = buildStackTraces(t);
    }

    private String buildStackTraces(Throwable t) {
        StringBuffer traces = new StringBuffer();
        StackTraceElement[] stacks = t.getStackTrace();
        for (int i = 0, length = stacks.length; i < length; i++) {
            StackTraceElement stack = stacks[i];
            if (i == 0) {
                traces.append(t.getClass().getName()).append(":").append(t.getMessage()).append("\n");
            }
            traces.append("at ").append(stack.getClassName()).append(".").append(stack.getMethodName()).append("(").append(stack.getFileName()).append(":").append(stack.getLineNumber()).append(")").append("\n");
        }
        return traces.toString();
    }

    public LogError(IThrowableProxy t) {
        this.code = 500;
        this.message = t.getMessage();
        this.file = getFileName(t);
        this.line = getLine(t);
        this.stacktraces = buildStackTraces(t);
    }

    private String buildStackTraces(IThrowableProxy t) {
        StringBuffer traces = new StringBuffer();
        StackTraceElementProxy[] stacks = t.getStackTraceElementProxyArray();
        for (int i = 0, length = stacks.length; i < length; i++) {
            StackTraceElement stack = stacks[i].getStackTraceElement();
            if (i == 0) {
                traces.append(t.getClassName()).append(":").append(t.getMessage()).append("\n");
            }
            traces.append("at ").append(stack.getClassName()).append(".").append(stack.getMethodName()).append("(").append(stack.getFileName()).append(":").append(stack.getLineNumber()).append(")").append("\n");
        }
        return traces.toString();
    }

    private static String getFileName(IThrowableProxy t) {
        if (t == null || t.getStackTraceElementProxyArray() == null || t.getStackTraceElementProxyArray().length < 1) {
            return null;
        }
        return t.getStackTraceElementProxyArray()[0].getStackTraceElement().getFileName();
    }

    private static int getLine(IThrowableProxy t) {
        if (t == null || t.getStackTraceElementProxyArray() == null || t.getStackTraceElementProxyArray().length < 1) {
            return 0;
        }
        return t.getStackTraceElementProxyArray()[0].getStackTraceElement().getLineNumber();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public String getStacktraces() {
        return stacktraces;
    }

    public void setStacktraces(String stacktraces) {
        this.stacktraces = stacktraces;
    }
}
