package com.lww.myLog.log.serializer;

/**
 * Created by Lww on 2017/11/9.
 */
public class StringSerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        StringBuffer stringBuffer = new StringBuffer();

        if (object == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append("\"" + object + "\"");
        }
        return stringBuffer;
    }
}
