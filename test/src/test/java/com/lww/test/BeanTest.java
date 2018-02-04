package com.lww.test;

import com.lww.test.mock.MockBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
public class BeanTest {

    @Mock
    private Bean mockBean;

    private Bean bean = new Bean();

    @Before
    public void beforeE() {
        MockitoAnnotations.initMocks(this);

        when(mockBean.add(anyInt(),anyInt())).thenReturn(3);
    }


    @Test
    public void add() throws Exception {
        int a = mockBean.add(1,2);
        System.out.println(a);
        a = mockBean.add(2,4);
        System.out.println(a);

    }

    @Test
    public void doub() throws Exception {
        int a = mockBean.doub(2);
        System.out.println(a);
        a = mockBean.doub(4);
        System.out.println(a);
    }


    @Test
    public void add2() throws Exception {
        int a = bean.add(1,2);
        System.out.println(a);
        a = bean.add(2,4);
        System.out.println(a);

    }

    @Test
    public void doub2() throws Exception {
        int a = bean.doub(2);
        System.out.println(a);
        a = bean.doub(4);
        System.out.println(a);

    }


}