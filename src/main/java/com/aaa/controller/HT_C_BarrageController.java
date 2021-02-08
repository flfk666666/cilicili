package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_BarrageService;
import com.aaa.service.HT_C_barragebindingSerivice;
import com.aaa.service.HT_C_listService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_cbarrage")
public class HT_C_BarrageController {

    @Resource
    HT_C_BarrageService ht_c_barrageService;
    @Resource
    HT_C_listService ht_c_listService;
    @Resource
    HT_C_barragebindingSerivice ht_c_barragebindingSerivice;

    //获取菜单
    @RequestMapping("ht_list")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/tables";
    }


    //查询全部的弹幕
    @RequestMapping("ht_findbarrage")
    @ResponseBody
    public List<Map<String,Object>> ht_findbarrage()
    {
        return ht_c_barrageService.ht_findbarrage();
    }


    //弹幕删除
    @RequestMapping("ht_barrageDel")
    @ResponseBody
    public int ht_barrageDel(Integer id){
        ht_c_barrageService.ht_barrageDel(id);
        return  ht_c_barragebindingSerivice.ht_binddelete(id);

    }



}
