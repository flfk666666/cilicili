package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_UserAdminService;
import com.aaa.service.HT_C_listService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ht_c_list")
public class HT_C_listController {
    @Resource
    HT_C_listService ht_c_listService;

    @Resource
    HT_C_UserAdminService ht_c_userAdminService;

    //获取菜单
    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin)SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/index";
    }




}
