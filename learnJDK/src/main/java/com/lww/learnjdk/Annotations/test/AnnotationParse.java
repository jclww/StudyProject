package com.lww.learnjdk.Annotations.test;

import com.lww.learnjdk.Annotations.FieldAnotation;
import com.lww.learnjdk.Annotations.MethodAnnotation;
import com.lww.learnjdk.Annotations.TypeAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationParse {
    public static void main(String[] args) throws ClassNotFoundException {
        printTypeAnnotation();
        printFieldAnnotation();
        printMethodAnnotation();
    }
    // 类注解
    public static void printTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.lww.learnjdk.Annotations.test.AnnotationTest");
//        clazz.isAnnotationPresent();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof TypeAnnotation) {
                TypeAnnotation typeAnnotation = (TypeAnnotation)annotation;
                System.out.println("TypeAnnotation value："+ typeAnnotation.value());
            } else {
                System.out.println("UnKnow Annotation");
            }
        }
    }
    // 属性注解
    public static void printFieldAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.lww.learnjdk.Annotations.test.AnnotationTest");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field :fields) {
            if (field.isAnnotationPresent(FieldAnotation.class)) {
                FieldAnotation fieldAnotation = (FieldAnotation) field.getAnnotation(FieldAnotation.class);
                System.out.println("FieldAnotation value：" + fieldAnotation.value());
            }
        }
    }
    // 方法注解
    public static void printMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.lww.learnjdk.Annotations.test.AnnotationTest");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method :methods) {
            if (method.isAnnotationPresent(MethodAnnotation.class)) {
                MethodAnnotation methodAnnotation = (MethodAnnotation) method.getAnnotation(MethodAnnotation.class);
                System.out.println("MethodAnnotation value：" + methodAnnotation.value() +
                        "name:" + methodAnnotation.name() + "address:" + methodAnnotation.address());

            } else {
                    System.out.println("UnKnow Annotation");
//                String name = method.getName();
//                String returnType = method.getAnnotatedReturnType().toString();
//                System.out.println("name:" + name + "\nreturnType:" + returnType + "\n" + method.toString());
            }
        }
    }

}
