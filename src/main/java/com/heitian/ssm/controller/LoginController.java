package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 兆禄 on 2017/3/13.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session,HttpServletRequest request, Model model,String username,String password){
        System.out.println("进入了登陆！！");
        session.setAttribute("username",username );
        System.out.println("用户名是"+username);
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();//清空session
        return "home";
    }
}
