package com.aaa.controller;

import com.aaa.entity.C_Folkopera;
import com.aaa.entity.C_UserAdmin;

import com.aaa.entity.C_list;
import com.aaa.service.HT_C_folkoperaService;
import com.aaa.service.HT_C_listService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_c_folkopera")
public class HT_C_folkoperaController {

    @Resource
    HT_C_folkoperaService ht_c_folkoperaService;

    @Resource
    HT_C_listService ht_c_listService;
    //获取菜单
    @RequestMapping("ht_folk_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/folk";
    }





//   查询番剧库
    @RequestMapping("ht_findfolkopera")
    @ResponseBody
    public List<C_Folkopera> ht_findfolkopera(){
        return ht_c_folkoperaService.ht_findfolkopera();
    }

//    模糊查询
    @RequestMapping("ht_findvague")
    @ResponseBody
    public List<Map<String,Object>> ht_findvague(String fname){
        return ht_c_folkoperaService.ht_findvague(fname);
    }

//提交审核
    @RequestMapping("ht_folksh")
    @ResponseBody
    public int pfolksh(int fid){
        return ht_c_folkoperaService.upfolksh("待审核",fid);
    }


}
