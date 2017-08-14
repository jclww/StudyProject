package com.lww.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lww.ssm.service.DommyGoodsServices;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/11.
 */
@RestController
public class DeleteGoodsController {
    @Resource
    private DommyGoodsServices dgs;
    @RequestMapping("/deleteBySn")
    @ResponseBody
    public String deleteBySn(ModelMap model, HttpServletRequest hsr,String goodsSn) {
        String sn = (hsr.getParameter("goodsSn"));
        System.out.println(sn);
        dgs.deleteBysn(sn);
        return "success";
    }
}
