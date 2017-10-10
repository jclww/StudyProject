package com.lww.learnjdk.Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodAnnotation {
    String value() default "";
    String name() default "";
    String address() default "";

}
