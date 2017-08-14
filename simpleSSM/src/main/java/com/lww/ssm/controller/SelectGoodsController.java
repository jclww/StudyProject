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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/7/10.
 */
@RestController
public class SelectGoodsController {
    @Resource
    private DommyGoodsServices dgs;
    @RequestMapping("/selectAllGoods")
    @ResponseBody
    public String selectAllGoods(ModelMap model, HttpServletRequest hsr) {
        int page = Integer.parseInt(hsr.getParameter("page"));


        Map<String,Integer> params = new HashMap<String,Integer>();
        params.put("beginIndex", Page.getBeginIndex(page));
        params.put("pageCounts",Page.pageCounts);
        List<Map<String,Object>> lm = dgs.findAllByLimit(params);
        System.out.println(JSON.toJSONString(lm));
        System.out.println(Page.getBeginIndex(page));
        return JSON.toJSONString(lm);
    }
    @RequestMapping("/selectBySn")
    @ResponseBody
    public String selectBySn(ModelMap model, HttpServletRequest hsr) {
        String sn = (hsr.getParameter("sn"));
        Map<String,Object> goods = dgs.findBySn(sn);
        return JSON.toJSONString(goods);
    }
    @RequestMapping("/selectByName")
    @ResponseBody
    public String selectByName(ModelMap model, HttpServletRequest hsr) {
        String name = (hsr.getParameter("name"));
        List<Map<String,Object>> lm = dgs.findByName(name);
        System.out.println(JSON.toJSONString(lm));
        return JSON.toJSONString(lm);
    }
    @RequestMapping("/selectByTime")
    @ResponseBody
    public String selectByTime(ModelMap model, HttpServletRequest hsr) {
        String begin = (hsr.getParameter("begin"));
        String end = (hsr.getParameter("end"));
        List<Map<String,Object>> lm = new ArrayList<Map<String, Object>>();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:m:s");
            Date startTime = sdf.parse(begin);
            Date endTime = sdf.parse(end);
            Map<String,Date> params = new HashMap<String,Date>();
            params.put("startTime",startTime);
            params.put("endTime",endTime);
            lm = dgs.findByTime(params);
            System.out.println(JSON.toJSONString(lm));
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            return JSON.toJSONString(lm);
        }
    }
}
