package com.lww.myLog.log;

import com.lww.myLog.log.factory.ObjectSerializerFactory;
import com.lww.myLog.log.serializer.ObjectSerializer;

/**
 * @author : Lww
 * @data : 2017/11/8
 * @description : Print
 * @version 2
 */
public class Print {
    public static String print(Object object) {
        ObjectSerializer objectSerializer = ObjectSerializerFactory.getObjectSerializer(object);

        StringBuffer objectString = objectSerializer.getObjectString(object);
//        System.out.println(objectString);
        return objectString.toString();
    }
}
