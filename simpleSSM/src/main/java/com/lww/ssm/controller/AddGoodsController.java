package com.lww.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;
import com.lww.ssm.service.DommyGoodsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/10.
 */
@Controller
public class AddGoodsController {
    @Resource
    private DommyGoodsServices dgs;
    @RequestMapping("/addGoods")
    @ResponseBody
    public String addGoods(ModelMap model, HttpServletRequest hsr) {
        String name = (String)hsr.getParameter("name");
        String createBy = (String)hsr.getParameter("create");
        String productTitle = (String)hsr.getParameter("slogan");
        String sn = (String)hsr.getParameter("shopId");
        String sellerId = (String)hsr.getParameter("spuId");
        Integer marketStatus = Integer.parseInt(hsr.getParameter("state"));
        Integer productType = Integer.parseInt(hsr.getParameter("type"));
        Integer apply = Integer.parseInt(hsr.getParameter("reviewState"));
        Boolean isTop = Boolean.parseBoolean(hsr.getParameter("top"));
        Boolean isValid = Boolean.parseBoolean(hsr.getParameter("valid"));
        DomyGoodsWithBLOBs dg = new DomyGoodsWithBLOBs();
//        System.out.println(name);
//        System.out.println(createBy);
//        System.out.println(productTitle);
//        System.out.println(sn);
//        System.out.println(sellerId);
//        System.out.println(apply);
//        System.out.println(isValid);
//        System.out.println(isTop);
        Date now = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String hehe = dateFormat.format( now );
        dg.setCreateDate(now);
        dg.setSn(sn);
        dg.setName(name);
        dg.setCreateBy(createBy);
        dg.setProductTitle(productTitle);
        dg.setSellerId(sellerId);
        dg.setMarketStatus(marketStatus);
        dg.setProductType(productType);
        dg.setApply(apply);
        dg.setIsTop(isTop);
        dg.setIsValid(isValid);
        dgs.createGoods(dg);
        return "Success";
    }
}
