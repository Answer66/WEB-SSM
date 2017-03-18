package com.heitian.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by 兆禄 on 2017/3/15.
 */
@Controller
public class HelloAction {

    @RequestMapping("/hello")//制定这个控制类对应的url
    public String hello(Model model){
        String message = "SpringMVC";
        //为model添加Attribute
        model.addAttribute("message",message);
        return "home";
    }
}
