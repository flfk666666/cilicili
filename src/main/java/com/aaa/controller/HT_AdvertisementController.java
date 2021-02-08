package com.aaa.controller;


import com.aaa.entity.C_Advertisement;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import com.aaa.service.C_AdvertisementService;
import com.aaa.service.HT_C_listService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("htadvert")
public class HT_AdvertisementController {
    @Resource
    C_AdvertisementService c_advertisementService;
    @Resource
    HT_C_listService ht_c_listService;

    @RequestMapping("seladvert")
    public String seladvert(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "ht/Advertising";
    }

    @RequestMapping("seladvertui")
    @ResponseBody
    public List<C_Advertisement> seladvertui(Model model){
        return c_advertisementService.seladvert();
    }

    @RequestMapping("upadvert")
    @ResponseBody
    public int upadvert(C_Advertisement c_advertisement){
        System.out.println(c_advertisement);


        return c_advertisementService.upadvert(c_advertisement);
    }



}
