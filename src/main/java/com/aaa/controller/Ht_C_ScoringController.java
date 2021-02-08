package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.service.HT_C_BarrageService;
import com.aaa.service.HT_C_listService;
import com.aaa.service.Ht_C_ScoringService;
import com.aaa.util.Epage;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_scoring")
public class Ht_C_ScoringController {
    @Resource
     Ht_C_ScoringService ht_c_scoringService;
    @Resource
    HT_C_listService ht_c_listService;
    //获取菜单
    @RequestMapping("ht_list")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/scoring";
    }
    //查询全部的弹幕
    @RequestMapping("ht_findscoring")
    @ResponseBody
    public List<Map<String,Object>>findAll(){
        return ht_c_scoringService.findAll();
    }
    //弹幕删除
    @RequestMapping("ht_scoringdel")
    @ResponseBody
    public int ht_scoringdel(Integer sid){
        ht_c_scoringService.delete(sid);
        return  ht_c_scoringService.delete(sid);
    }
    //分页
    @RequestMapping("c_page")
    @ResponseBody
    public Epage<C_Scoring> epage(Integer page, Integer rows){
        return ht_c_scoringService.findAllPage(page,rows);
    }
}
