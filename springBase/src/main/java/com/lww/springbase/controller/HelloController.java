package com.lww.springbase.controller;

import com.alibaba.fastjson.JSON;
import com.lww.springbase.enity.User;
import com.lww.springbase.service.AspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lww
 * @date 2017/10/23
 */
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private AspectService aspectService;

    @RequestMapping("/selectByName")
    @ResponseBody
    public String selectByName(ModelMap model, HttpServletRequest hsr) {
        logger.info("asdasdas");
        String str = "sadsa";
        return JSON.toJSONString(str);
    }

    @RequestMapping("/post")
    @ResponseBody
    public String postTest(@RequestBody User user) {

        return "success";
    }

    @RequestMapping("/aspect")
    @ResponseBody
    public String aspectTest(User user) {
        String str = aspectService.doSomeThing(user.getName());
        return "success";
    }

    @RequestMapping("/transactional")
    @ResponseBody
    public String transactionalTest(User user) {
        String str = aspectService.transactionalMethod(user.getName());
        return "success";
    }

}
