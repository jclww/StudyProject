package com.lww.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/8/8.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String addGoods(ModelMap model, HttpServletRequest hsr) {
//        String name = (String) hsr.getParameter("name");
//        System.out.println("s");
        return "test";
    }
}
