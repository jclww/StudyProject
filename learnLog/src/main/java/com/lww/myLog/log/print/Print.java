package com.lww.myLog.log.print;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author : Lww
 * @data : 2017/11/8
 * @description : Print
 * @version 1.0
 */
public class Print {
    public static void print(Object object) throws NoSuchFieldException, IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        Class objectClass = object.getClass();
        while (objectClass.getSuperclass() != null){
            System.out.println(objectClass.getName());
//            Field[] fields = objectClass.getDeclaredFields();


            String objectString = objectString(objectClass, object);

            System.out.println(objectString);
            objectClass = objectClass.getSuperclass();
        }
    }

    private static String objectString(Class objectClass, Object object) throws IllegalAccessException {

        Field[] fields = objectClass.getDeclaredFields();
        Method[] methods = objectClass.getDeclaredMethods();

        String[] hasGetFieldsName = getHasGetMethodFieldName(methods);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for (Field field : fields) {
            if (true) {
//            if (needPrint(field, hasGetFieldsName, object)) {
                field.setAccessible(true);

                Object value = field.get(object);
                if (value != null) {
                    String type = field.getType().toString();
//                System.out.println("type:" + type);

                    String[] strings = type.split(" ");
//                for (int i = 0; i < strings.length; i++) {
//                    System.out.println(strings[i]);
//                }
                    if (strings.length == 1) {
                        // 处理基本数据类型
                        stringBuffer.append(doBasicDataType(field, object));
                    } else if (strings.length == 2) {
                        if (strings[1].startsWith("[")) {
                            if (strings[1].startsWith("[L")) {
                                // 处理对象类型数组
                                stringBuffer.append(doObjectArrType(field, object, strings[1]));
                            } else {
                                // 处理基础数据类型数组
                                stringBuffer.append(doBasicDataArrType(field, object));
                            }
                        } else {
                            //处理对象类型
                            stringBuffer.append(doObjectType(field, object, strings[1]));
                        }
                    } else {
                        throw new IllegalAccessException("出错");
                    }

//                System.out.print("name:" + field.getName());
//                System.out.println("\tvalue:" + field.get(object));
                }
            }
        }
        if (stringBuffer.length()>1){
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    //处理对象数组类型
    private static StringBuffer doObjectArrType(Field field, Object object, String string) throws IllegalAccessException {

        Object basicArr = field.get(object);
        int length = Array.getLength(basicArr);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\""+field.getName()+"\":[");
        System.out.println("Arrayasadasdadsadsdds"+length);
        for (int i = 0; i < length; i++) {
            Object arrIndex = Array.get(basicArr,i);
            if (arrIndex == null){
                stringBuffer.append(arrIndex+",");
            } else {
                stringBuffer.append(objectString(Object.class, object)+",");
//                doObjectType();
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("],");
        return stringBuffer;

//        return field.getName()+":"+field.get(object)+",";
    }
    //处理对象类型
    private static String doObjectType(Field field, Object object, String string) throws IllegalAccessException {
        if (String.class.isAssignableFrom(field.getType())) {
            return "\""+field.getName()+"\":\""+field.get(object)+"\",";
        }
        if (Enum.class.isAssignableFrom(field.getType())) {
            return "\""+field.getName()+"\":\""+field.get(object)+"\",";
        }
        if (Map.class.isAssignableFrom(field.getType())) {
            return "\""+field.getName()+"\":\""+field.get(object)+"\",";
        }
        if (List.class.isAssignableFrom(field.getType())) {
            return "\""+field.getName()+"\":\""+field.get(object)+"\",";
        }
//        return "\""+field.getName()+"\":\""+field.get(object)+"\",";


        return "\""+field.getName()+"\":"+objectString(field.get(object).getClass(),field.get(object))+",";
    }
    // 处理基本数据类型数组
    private static StringBuffer doBasicDataArrType(Field field, Object object) throws IllegalAccessException {
        Object basicArr = field.get(object);
        int length = Array.getLength(basicArr);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\""+field.getName()+"\":[");
        for (int i = 0; i < length; i++) {
            stringBuffer.append(Array.get(basicArr,i)+",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("],");
        return stringBuffer;
    }
    // 处理基本数据类型
    private static String doBasicDataType(Field field, Object object) throws IllegalAccessException {
        return "\""+field.getName()+"\":"+field.get(object)+",";
    }

    private static boolean needPrint(Field field, String[] hasGetFieldsName, Object object) {
        try {
            field.get(object);
        } catch (IllegalAccessException e) {
            if (!fieldNameIn(field.getName(), hasGetFieldsName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fieldNameIn(String name, String[] hasGetFieldsName) {
        for (int i = 0; i < hasGetFieldsName.length; i++) {
            if (name.equals(hasGetFieldsName[i])) {
                return true;
            }
        }
        return false;
    }

    private static String[] getHasGetMethodFieldName(Method[] methods) {
        String[] fieldNames = new String[methods.length];
        int i = 0;
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String fieldName = getFieldName(methodName.substring(3));
                fieldNames[i++] = fieldName;
            }
        }
        return fieldNames;
    }
    private static String getFieldName(String name) {
//        System.out.println(name);
        char[] cs = name.toCharArray();
//        if (cs.length <=0){
//            return "";
//        }
        if (cs[0] <= 'Z'){
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }

    public static void println(Object object) throws NoSuchFieldException, IllegalAccessException {
        print(object);
        System.out.println();
    }
}

//for (Method method : methods) {
//        String methodName = method.getName();
//        if (methodName.startsWith("get")) {
//        String fieldName = getFieldName(methodName.substring(3));
//        Field field = objectClass.getField(fieldName);
//        field.setAccessible(true);
//        System.out.println(field.getName() + field.get(object));
//        }
//        }
