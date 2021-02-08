package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_UserAdminService;
import com.aaa.service.HT_C_listService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ht_juris")
public class HT_JurisdictionController {


    @Resource
    HT_C_listService ht_c_listService;


    @Resource
    HT_C_UserAdminService ht_c_userAdminService;

    //获取菜单
    @RequestMapping("ht_juris_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "ht/list";
    }


    //显示全部
    @RequestMapping("ht_jurisquery")
    @ResponseBody
    public List<C_list> ht_jurisquery(){
        return ht_c_listService.ht_listquery();
    }

        //添加
    @RequestMapping("ht_jurisadd")
    @ResponseBody
    public int ht_jurisadd(C_list c_list){
        return ht_c_listService.htadd(c_list);
    }

    //修改
    @RequestMapping("ht_jurisupdate")
    @ResponseBody
    public int ht_jurisupdate(C_list c_list){
        return ht_c_listService.htupdate(c_list);
    }

    //删除
    @RequestMapping("ht_jurisdel")
    @ResponseBody
    public int ht_jurisdel(Integer lid){
        return ht_c_listService.htdel(lid);
    }
}
