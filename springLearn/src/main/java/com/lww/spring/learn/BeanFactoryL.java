package com.lww.spring.learn;

import com.lww.spring.learn.bean.BaseMailBean;
import com.lww.spring.learn.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lww on 2017/9/5.
 */
public class BeanFactoryL {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("spring.xml");
        TestBean testBean = (TestBean)context.getBean("testBean");
        testBean.method();
        BeanFactoryL a = new BeanFactoryL();
        BaseMailBean mailBean = (BaseMailBean) context.getBean("mailBean");
        System.out.println(mailBean.getProtocol());

    }
}
