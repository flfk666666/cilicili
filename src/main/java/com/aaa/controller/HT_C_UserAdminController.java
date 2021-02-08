package com.aaa.controller;
import com.aaa.entity.C_UserAdmin;
import com.aaa.service.HT_C_UserAdminService;
import com.aaa.util.Epage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("admin")
public class HT_C_UserAdminController {


    @Resource
    HT_C_UserAdminService ht_c_userAdminService;

    //显示页面登录
    @RequestMapping("ht_login_show")
    public String ht_login_show(){
        return "/ht/login";
    }


    //登录提交
    @RequestMapping("ht_login_submit")
    public String ht_login_submit(String uname,String pwd,Model model){

        Subject subject =SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uname,pwd);
        try{
            subject.login(token);
            //这里我就不抛出逐个错误了 这里可以通过抛出的异常来判断用户到底输错了什么
        }catch (Exception e){
            model.addAttribute("msg","账号或密码错误");
            return "/ht/login";
        }
            return "redirect:/admin/ht_login_success";
    }

    //显示登录成功页面
    @RequestMapping("ht_login_success")
    public String ht_login_success()
    {
        return "redirect:/ht_c_list/ht_list_show";
    }



    //退出登录
    @RequestMapping("ht_login_out")
    public String login_out()
    {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //重定向到现实登录页面
        return "redirect:login_show";
    }

}
