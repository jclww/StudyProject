package com.lww.myLog.log.serializer;

/**
 * Created by Lww on 2017/11/10.
 */
public class NullPointSerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("null");
        return stringBuffer;
    }
}