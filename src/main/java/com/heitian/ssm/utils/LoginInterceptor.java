package com.heitian.ssm.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 兆禄 on 2017/3/15.
 */
public class LoginInterceptor implements HandlerInterceptor{
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object hander,Exception exc)throws Exception{

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object hander,ModelAndView modelAndView)throws Exception{

    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception{
//        System.out.println("进入了拦截器的preHandle");
        String url = request.getRequestURI();
        if(url.indexOf("login")>=0){
            return true;
        }
        HttpSession session =request.getSession();
        String userName = (String)session.getAttribute("username");
        System.out.println(userName);
        if(userName != null){
            System.out.println(userName);
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/loginTest.jsp").forward(request,response);
        return false;
    }

}
