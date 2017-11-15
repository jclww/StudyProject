package com.lww.myLog.log.serializer;

import com.lww.myLog.log.factory.ObjectSerializerFactory;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lww on 2017/11/10.
 */
public class MapSerializer implements ObjectSerializer {

    @Override
    public StringBuffer getObjectString(Object object) {
        Map map = (Map) object;
        Iterator var = map.entrySet().iterator();

        StringBuffer stringBuffer = new StringBuffer();
        ObjectSerializer keySerializer = null;
        ObjectSerializer valueSerializer = null;
        stringBuffer.append("{");
        while(var.hasNext()) {
            Map.Entry entry = (Map.Entry)var.next();
            Object entryKey = entry.getKey();
            keySerializer = ObjectSerializerFactory.getObjectSerializer(entryKey);
            Object value = entry.getValue();
            valueSerializer = ObjectSerializerFactory.getObjectSerializer(value);
            stringBuffer.append(keySerializer.getObjectString(entryKey)+":"+valueSerializer.getObjectString(value)+",");
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append("}");
        return stringBuffer;
    }
}
