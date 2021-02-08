package com.aaa.controller;


import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_Video;
import com.aaa.entity.C_list;



import com.aaa.service.HT_C_VideoService;
import com.aaa.service.HT_C_listService;
import com.aaa.util.Epage;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("c_video")
public class HT_C_VideoController {
    @Resource
    HT_C_VideoService ht_c_videoService;

    @Resource
    HT_C_listService ht_c_listService;
    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/video";
    }

//    @RequestMapping("show")
//    public String findAll(Model model){
//        List<C_video>list=ht_c_videoService.findAll();
//        model.addAttribute("list",list);
//        return "video";
//    }


    @RequestMapping("c_page")
    @ResponseBody
    public Epage<C_Video>epage(Integer page, Integer rows){
        return ht_c_videoService.findAllPage(page,rows);
    }


    @RequestMapping("c_update")
    @ResponseBody
    public int c_update(String state,int vid){
        System.out.println(state);
        C_Video c_video=new C_Video();
        c_video.setVid(vid);
        c_video.setState(state);
        return ht_c_videoService.update(c_video);
    }
}
