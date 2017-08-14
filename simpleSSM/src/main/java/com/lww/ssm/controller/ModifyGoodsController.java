package com.lww.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.service.DommyGoodsServices;
import com.lww.ssm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/12.
 */
@Controller
public class ModifyGoodsController {
    @Resource
    private DommyGoodsServices dgs;
    @RequestMapping("/modify")
    public String modify(ModelMap model, HttpServletRequest hsr) {
        String sn = hsr.getParameter("goodsId");
        Map<String,Object> goods = dgs.findDetailBySn(sn);
        model.addAttribute("goods",goods);
        System.out.println(JSON.toJSONString(goods)+"sn:"+sn);
        return "goodsEdit";
    }
    @RequestMapping("/modifyBySn")
    public String modifyBySn(ModelMap model, HttpServletRequest hsr) {
        String name = hsr.getParameter("name");
        String productTitle = hsr.getParameter("productTitle");
        String sn = hsr.getParameter("sn");
        String editBy = hsr.getParameter("editBy");
        Date now = new Date();

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name", name);
        params.put("productTitle",productTitle);
        params.put("sn",sn);
        params.put("editBy",editBy);
        params.put("now",now);


         dgs.updateBySn(params);
        return "success";
    }
}
