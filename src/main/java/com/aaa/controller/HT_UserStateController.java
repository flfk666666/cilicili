package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_UserAdminService;
import com.aaa.service.HT_C_listService;
import com.aaa.util.Epage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ht_user")
public class HT_UserStateController {

    @Resource
    HT_C_UserAdminService ht_c_userAdminService;
    @Resource
    HT_C_listService ht_c_listService;

//    //显示到主页面
    @RequestMapping("ht_usershow")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/userment";
    }

    //根据状态查询出正常的用户
    @RequestMapping("HT_findByState")
    @ResponseBody
    public List<C_UserAdmin> HT_findByState(String state){
        return ht_c_userAdminService.HT_findByState(state);
    }

    //查询出禁用的用户
    @RequestMapping("ht_findNostate")
    @ResponseBody
    public List<C_UserAdmin> ht_findNostate(String state){
        return ht_c_userAdminService.ht_findNOState(state);
    }

    //禁用或者回复用户
    @RequestMapping("STATE")
    @ResponseBody
    public int state(String state,Integer uid){
        return ht_c_userAdminService.updatestate(state, uid);
    }


}
