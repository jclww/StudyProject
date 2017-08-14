package com.lww.ssm.test.mybatis;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;
import com.lww.ssm.service.DommyGoodsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/11.
 */
public class TestLimit {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");

        DomyGoodsWithBLOBs dg = new DomyGoodsWithBLOBs();
        DommyGoodsServices dgs = (DommyGoodsServices)context.getBean("dommyGoods");
//        System.out.println(dgs.deleteByPrimaryKey(1l));
        Map<String,Integer> params = new HashMap<String,Integer>();
        params.put("beginIndex",1);
        params.put("pageCounts",20);
        List<Map<String,Object>> lm = dgs.findAllByLimit(params);

//        DomyGoodsWithBLOBs dgwb = dgs.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(lm));


    }
}
