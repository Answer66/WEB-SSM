package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 兆禄 on 2017/3/13.
 */
@Controller
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session,HttpServletRequest request, Model model,String username,String password){
        System.out.println("进入了登陆！！");
        logger.info("这是测试日志文件");
        User user = userService.userLogin(username,password);
        if(user!=null){
            logger.info("登陆成功");
            return "home";
        }
        session.setAttribute("username",username );
        logger.info("username="+username+"            userpassword="+password);
        return "loginTest";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();//清空session
        return "home";
    }
}
