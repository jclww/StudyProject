package com.lww.learnjdk.Annotations.test;


import com.lww.learnjdk.Annotations.FieldAnotation;
import com.lww.learnjdk.Annotations.MethodAnnotation;
import com.lww.learnjdk.Annotations.TypeAnnotation;

@TypeAnnotation("TypeAnnotation")
public class AnnotationTest {
    @FieldAnotation("asds")
    public String name;

    @MethodAnnotation(value = "sdsada", name = "testMethod", address = "阿打算打多少")
    public void testMethod() {

    }
    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();
        System.out.println(test.name);
    }
}
