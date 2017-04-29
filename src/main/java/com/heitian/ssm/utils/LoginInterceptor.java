package com.heitian.ssm.utils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 兆禄 on 2017/3/15.
 */
public class LoginInterceptor implements HandlerInterceptor{

    private Logger logger = Logger.getLogger(LoginInterceptor.class);
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object hander,Exception exc)throws Exception{

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object hander,ModelAndView modelAndView)throws Exception{

    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception{
        logger.info("进入了拦截器");
        HttpSession session =request.getSession();
        String userName = (String)session.getAttribute("username");
        String url = request.getRequestURI();
        if(!url.contains("login")){
            session.setAttribute("originURL",url );
        }
        logger.info("拦截前URL:"+url);
        if(url.contains("login")){
            return true;
        }
        if(userName != null){
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

}
