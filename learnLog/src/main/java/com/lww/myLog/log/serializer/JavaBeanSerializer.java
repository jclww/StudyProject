package com.lww.myLog.log.serializer;


import com.lww.myLog.log.factory.ObjectSerializerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Lww on 2017/11/9.
 */
public class JavaBeanSerializer implements ObjectSerializer {
    private boolean printNull = false;
    private boolean printAll = false;

    @Override
    public StringBuffer getObjectString(Object object) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        Class objectClass = object.getClass();
        while (objectClass.getSuperclass() != null){
            stringBuffer.append(objectString(objectClass, object));
            stringBuffer.append(",");
            objectClass = objectClass.getSuperclass();
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append("}");
        return stringBuffer;
    }

    private StringBuffer objectString(Class objectClass, Object object) {

        StringBuffer stringBuffer = new StringBuffer();
        Field[] fields = objectClass.getDeclaredFields();
        Method[] methods = objectClass.getDeclaredMethods();
        String[] hasGetFieldsName = getHasGetMethodFieldName(methods);

        for (Field field : fields) {
            if (printAll || needPrint(field, hasGetFieldsName, object)) {

                field.setAccessible(true);
                Object fieldObject = null;
                try {
                    fieldObject = field.get(object);
                } catch (IllegalAccessException e) {
                    System.out.println("出错了，暂时没有日志。。。");
                }
                if (!printNull && fieldObject == null) {

                } else {
                    ObjectSerializer fieldType = ObjectSerializerFactory.getObjectSerializer(fieldObject);
                    stringBuffer.append("\""+field.getName()+"\":"+fieldType.getObjectString(fieldObject)+",");
                }
            }
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer;
    }

    private boolean needPrint(Field field, String[] hasGetFieldsName, Object object) {
        try {
            field.get(object);
        } catch (IllegalAccessException e) {
            if (!fieldNameIn(field.getName(), hasGetFieldsName)) {
                return false;
            }
        }
        return true;
    }

    private boolean fieldNameIn(String name, String[] hasGetFieldsName) {
        for (int i = 0; i < hasGetFieldsName.length; i++) {
            if (name.equals(hasGetFieldsName[i])) {
                return true;
            }
        }
        return false;
    }

    private String[] getHasGetMethodFieldName(Method[] methods) {
        String[] fieldNames = new String[methods.length];
        int i = 0;
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") && methodName.length() > 3) {
                String fieldName = getFieldName(methodName.substring(3));
                fieldNames[i++] = fieldName;
            }
        }
        return fieldNames;
    }

    private String getFieldName(String name) {
        char[] cs = name.toCharArray();
        if (cs[0] <= 'Z'){
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }

}
