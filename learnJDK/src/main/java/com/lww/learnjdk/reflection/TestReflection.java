package com.lww.learnjdk.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lenovo
 * @data: 2017/11/8
 * @description: TestReflection
 *
 * @note
 * getFields();//获取包括自身和继承（实现）过来的所有的public方法(只有public)
 * getDeclaredFields();//获取自身所有的属性(private、public、protected，和访问权限无关)，不包括继承的
 *
 * getMethods();//获取包括自身和继承（实现）过来的所有的public属性(只有public)
 * getDeclaredMethods();//获取自身所有的方法(private、public、protected，和访问权限无关)，不包括继承的
 *
 * 在访问私有属性私有方法适合需要加上 setAccessible(true); 否则报异常
 *
 *
 */
public class TestReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        TestClassB a = new TestClassB();
        a.setPrivateInt(1);
        a.setPrivateString("aString");
        a.setPublicString("asda");
        a.setbInt(2);
        a.setbString("bString");
        Class aClass = (Class) a.getClass();

        Class bClass = aClass.getSuperclass();
        Class oClass = bClass.getSuperclass();   // Object
//        Class nClass = oClass.getSuperclass(); // Object不存在父类

        System.out.println(bClass.getSimpleName());
        System.out.println(oClass.getSimpleName());

        Class[] intfaces = aClass.getInterfaces();
        System.out.println(intfaces.length);
        if (intfaces == null || intfaces.length == 0) {
            System.out.println("没有实现接口");
        }


        Field[] fs = aClass.getDeclaredFields();
        for(int i = 0 ; i < fs.length; i++){
            Field f = fs[i];
            f.setAccessible(true); //设置些属性是可以访问的
            Object val = f.get(a);//得到此属性的值
            System.out.println("name:"+f.getName()+"\t value = "+val);
        }

        Method[] methods = aClass.getDeclaredMethods();
        for(int i = 0 ; i < methods.length; i++){
            Method method = methods[i];
            method.setAccessible(true); //设置些属性是可以访问的

            System.out.println("MethodName:"+method.getName());
            if (method.getName().startsWith("set")) {
                continue;
            }
            method.invoke(a);

        }
    }
}


//            String type = f.getType().toString();//得到此属性的类型
//            if (type.endsWith("String")) {
//                System.out.println(f.getType()+"\t是String");
//                f.set(bean,"12") ;        //给属性设值
//            }else if(type.endsWith("int") || type.endsWith("Integer")){
//                System.out.println(f.getType()+"\t是int");
//                f.set(bean,12) ;       //给属性设值
//            }else{
//                System.out.println(f.getType()+"\t");
//            }