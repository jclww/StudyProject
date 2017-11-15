package com.lww.myLog.log.factory;

import com.lww.myLog.log.serializer.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by Lww on 2017/11/9.
 */
public class ObjectSerializerFactory {
    private static StringSerializer stringSerializer = new StringSerializer();
    private static BasicTypeUniversalSerializer universalSerializer = new BasicTypeUniversalSerializer();
    private static JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer();
    private static NullPointSerializer nullPointSerializer = new NullPointSerializer();
    private static ArraySerializer arraySerializer = new ArraySerializer();
    private static DateSerializer dateSerializer = new DateSerializer();
    private static MapSerializer mapSerializer = new MapSerializer();
    private static EnumSerializer enumSerializer = new EnumSerializer();

    private static String CLASS_SPLIT = " ";
    private static String ARR_SIGN = "[";



    public static ObjectSerializer getObjectSerializer(Object object){
        if (object == null) {
            return nullPointSerializer;
        }
        if (object.getClass().isArray()) {
            return arraySerializer;
        }
        if (objectIsBasicType(object)){
            return universalSerializer;
        }
        if (object instanceof String) {
            return stringSerializer;
        }
        if (object instanceof Date) {
            return dateSerializer;
        }
        if (object instanceof Map) {
            return mapSerializer;
        }
        if (object instanceof Enum) {
            return enumSerializer;
        }
        return javaBeanSerializer;
    }

    private static boolean objectIsBasicType(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        if (object instanceof Boolean) {
            return true;
        }
        if (object instanceof Character) {
            return true;
        }
        if (object instanceof Float) {
            return true;
        }
        if (object instanceof Double) {
            return true;
        }
        return false;
    }

    public static ObjectSerializer getFieldSerializer(Class clazz){
        if (clazzIsBasicType(clazz)){
            return universalSerializer;
        }
        if (String.class.isAssignableFrom(clazz)) {
            return stringSerializer;
        }
        return javaBeanSerializer;
    }

    private static boolean clazzIsBasicType(Class clazz) {
        if (Integer.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Boolean.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Character.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Float.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Double.class.isAssignableFrom(clazz)) {
            return true;
        }
        return false;
    }

}
