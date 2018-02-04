package com.lww.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;

/**
 * @author lww
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/bean-test.xml"})
@EnableTransactionManagement
@TestExecutionListeners
public class BaseTest {

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
//        Mockito.when(oaService.subDepartmentList(Mockito.anyLong())).thenReturn(new ArrayList<>());
    }

    protected void injectField(Object target, String fieldName, Object value){
        try {
//            Object bean = ReflectionUtils.getTarget(target);
//            ReflectionUtils.injectField(bean, value, fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected <T> T mockBean(Class<T> beanClass){
//        return MockTestUtil.getJavaBean(beanClass);
        return null;
    }


    @Test
    public void testAlwaysOk() {
        Assert.assertTrue(true);
    }
}
