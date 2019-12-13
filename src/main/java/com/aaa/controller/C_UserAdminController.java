package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.service.C_UserAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("qt_C_User")
public class C_UserAdminController {

    @Resource
    C_UserAdminService c_userAdminService;
    @RequestMapping("login")
    public String login(String uname, String pwd, HttpSession session){
        C_UserAdmin userAdmin = c_userAdminService.login(uname, pwd);
        if(null==userAdmin){
            session.setAttribute("msg","用户名或密码错误");
            return "/qt/login";
        }else {
            session.setAttribute("userAdmin",userAdmin);
        }
        return "redirect:/qt/index";
    }

    @RequestMapping("register")
    @ResponseBody
    public int register(C_UserAdmin c_userAdmin){
        c_userAdmin.setIdentity("普通用户");
        c_userAdmin.setGrade(1);
        c_userAdmin.setEmpirical(0);
        c_userAdmin.setCCoin(2);
        c_userAdmin.setState("正常");
        c_userAdmin.setHeadimg("img/morentouxiang.jpg");
        c_userAdmin.setSpaceimg("img/beijing1.png");
        c_userAdmin.setSex("男");
        return c_userAdminService.register(c_userAdmin);
    }


    @RequestMapping("goPersonalspace")
    public String goPersonalspace(Model model,int uid){

        C_UserAdmin c_userAdmin=c_userAdminService.selone(uid);

        model.addAttribute("userspace",c_userAdmin);

        return "/qt/Personalspace";
    }

    @RequestMapping("zx")
    public String zx(HttpSession session){
        session.removeAttribute("userAdmin");
        return "redirect:/qt/index";
    }


    @RequestMapping("updateUserInfo")
    @ResponseBody
    public int updateUserInfo(C_UserAdmin c_userAdmin,HttpSession session){
        C_UserAdmin c_userAdminOld=(C_UserAdmin)session.getAttribute("userAdmin");
        c_userAdminOld.setSex(c_userAdmin.getSex());
        c_userAdminOld.setAlias(c_userAdmin.getAlias());
        c_userAdminOld.setPersonalized(c_userAdmin.getPersonalized());
        System.out.println("c_userAdmin = " + c_userAdminOld);
        session.setAttribute("userAdmin",c_userAdminOld);
        return c_userAdminService.updateUserInfo(c_userAdminOld);
    }


}
