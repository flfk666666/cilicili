package com.aaa.controller;

import com.aaa.entity.C_Folkopera;
import com.aaa.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("vague")
public class VagueController {

    @Resource
    C_UserAdminService c_userAdminService;
    @Resource
    C_FolkoperaService c_folkoperaService;
    @Resource
    C_VideoService c_videoService;
    @Resource
    C_selFolkService c_selFolkService;


    //根据名称去查询  视频 番剧 用户
    @RequestMapping("vagueshow")
    public String vagueshow(Model model,String name){
        model.addAttribute("c_user",c_userAdminService.qt_vagueuname(name));
        System.out.println("c_userAdminService.qt_vagueuname(name) = " + c_userAdminService.qt_vagueuname(name));
        model.addAttribute("c_folk",c_folkoperaService.qtfindvaguefname(name));
        List<Map<String,Object>> selfolk=c_folkoperaService.qtfindvaguefname(name);
        int i=1;

        for (Map<String,Object> s:selfolk){
            Integer fid=(Integer) s.get("fid");
            model.addAttribute("fj"+i,c_selFolkService.selfolknumber(fid));
            System.out.println(i);
            i++;
        }
        model.addAttribute("c_video",c_videoService.qt_queryvaguevaname(name));
        return "qt/search";
    }

    //搜索框点击搜索
    @RequestMapping("qt_findbyname")
    @ResponseBody
    public String qt_findbyname(String name, Model model){
        List<Map<String,Object>> vague =c_videoService.qt_queryvaguevaname(name);
        List<Map<String,Object>> c_folk=c_folkoperaService.qtfindvaguefname(name);
        List<Map<String,Object>> c_user =c_userAdminService.qt_vagueuname(name);
        if(vague.size()>0||c_folk.size()>0||c_user.size()>0){
            model.addAttribute("vague",vague);
            model.addAttribute("c_folk",c_folk);
            model.addAttribute("c_user",c_user);

            return "1";
        }
        return "2";
    }

        //查询全部 视频 番剧 用户
        @RequestMapping("qt_show")
        public String show(Model model){
            model.addAttribute("c_video",c_videoService.findC_Video());
            model.addAttribute("c_folk",c_folkoperaService.qt_findfolkopera());

            model.addAttribute("c_user",c_userAdminService.qt_useradminfindAll());
            System.out.println("c_userAdminService.qt_useradminfindAll() = " + c_userAdminService.qt_useradminfindAll());
            return "qt/search";
        }









}
