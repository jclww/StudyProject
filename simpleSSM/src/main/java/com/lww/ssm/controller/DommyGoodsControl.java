package com.lww.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;
import com.lww.ssm.service.DommyGoodsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/7/7.
 */
@Controller
@RequestMapping("dommyGoods")
public class DommyGoodsControl {
    @Resource
    private DommyGoodsServices dgs;
    @RequestMapping("/getFirst")
    public String toIndex(ModelMap model) {
        DomyGoodsWithBLOBs dgwb = dgs.selectByPrimaryKey(1L);
        String info = JSON.toJSONString(dgwb);
        model.addAttribute("goods", info);
        model.addAttribute("mes","hello");
        System.out.println(info);
        return "success";
    }
}
