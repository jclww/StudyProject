package com.lww.ssm.test.mybatis;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;
import com.lww.ssm.service.DommyGoodsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/7/7.
 */

public class TestGoods {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");

        DomyGoodsWithBLOBs dg = new DomyGoodsWithBLOBs();
        dg.setId(123L);
        dg.setName("search");
        dg.setMarketStatus(1);
        dg.setIsTop(true);
        dg.setIsValid(true);
        dg.setProductType(1);
        dg.setApply(123);
        dg.setProductTitle("很好");
        dg.setSn("好");
        dg.setSellerId("123435S");
        DommyGoodsServices dgs = (DommyGoodsServices)context.getBean("dommyGoods");
//        System.out.println(dgs.deleteByPrimaryKey(1l));
        DomyGoodsWithBLOBs dgwb = dgs.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(dgwb));


    }
}
