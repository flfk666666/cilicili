package com.aaa.util;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常帮助类 用来捕获全局异常
 */
@ControllerAdvice
public class GlobalExceptionHelp {

    //注解全局捕获UnauthorizedException.class 这个异常
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public  String defaultExceptionHandler(HttpServletRequest request,Exception e)
    {
        e.printStackTrace();
        return "对不起,你没有访问权限";
    }

}
