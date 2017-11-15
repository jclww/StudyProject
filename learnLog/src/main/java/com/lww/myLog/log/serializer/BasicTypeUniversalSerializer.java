package com.lww.myLog.log.serializer;

/**
 * Created by Lww on 2017/11/9.
 */
public class BasicTypeUniversalSerializer extends BasicDataSerializer {
    @Override
    public StringBuffer getBasicDataTypeString(Object object) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(object);
        return stringBuffer;
    }
}
