package com.lww.myLog.log.serializer;

import com.lww.myLog.log.factory.ObjectSerializerFactory;

import java.lang.reflect.Array;

/**
 * Created by Lww on 2017/11/10.
 */
public class ArraySerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        int length = Array.getLength(object);
        for (int i = 0; i < length; i++) {
            Object arrayIndex = Array.get(object,i);
            ObjectSerializer fieldType = ObjectSerializerFactory.getObjectSerializer(arrayIndex);
            stringBuffer.append(fieldType.getObjectString(arrayIndex)+",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");
        return stringBuffer;
    }
}
