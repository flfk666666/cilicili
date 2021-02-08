package com.aaa.controller;




import com.aaa.entity.C_Folkshopping;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;


import com.aaa.service.HT_C_FolkshoppingService;
import com.aaa.service.HT_C_folkoperaService;
import com.aaa.service.HT_C_listService;
import com.aaa.test.S;
import com.aaa.util.Epage;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("c_folk")
public class HT_C_FolkShoppingController {
    @Resource
    HT_C_FolkshoppingService ht_c_folkshoppingService;
    @Resource
    HT_C_listService ht_c_listService;
    @Resource
    HT_C_folkoperaService c_folkoperaService;



    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/folkshopping";
    }
    @RequestMapping("ht_c_page")
    @ResponseBody
    public Epage<C_Folkshopping>epage(Integer page, Integer rows){

        return ht_c_folkshoppingService.findPage(page,rows);
    }
    @RequestMapping("findAll")
    @ResponseBody
     public List<C_Folkshopping>findAll(){
        return ht_c_folkshoppingService.findAll();
    }

    //查看我的番剧
    @RequestMapping("ht_selmefolk")
    public String selmefolk(Model model){
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);

        //查询已上架
        model.addAttribute("ysjfolk",c_folkoperaService.selfolksjyn("已上架"));
        //查询未上架
        model.addAttribute("wsjfolk",c_folkoperaService.selfolksjyn("未上架"));
        return "/ht/selfolk";
    }

    //下架
    @RequestMapping("folksj")
    public String folksj(String state,int fid){

        c_folkoperaService.upfolksj(state,fid);
        return "redirect:/c_folk/ht_selmefolk";
    }

    //取消番剧审核
    @RequestMapping("qxfolksh")
    public String upfolksh(int fid){
        c_folkoperaService.upfolksj("未购入",fid);
        return "redirect:/c_folk/ht_folksh";
    }

    //通过番剧审核
    @RequestMapping("tgfolksh")
    public String tgfolksh(int fid){
        c_folkoperaService.upfolksj("未上架",fid);
        return "redirect:/c_folk/ht_jlfolksh";
    }

    //查询番剧审核
    @RequestMapping("ht_folksh")
    public String ht_folksh(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        //查看自己提交的审核番剧
        model.addAttribute("dshfolk",c_folkoperaService.selfolksjyn("待审核"));

        return "/ht/folksh";
    }

    //查询番剧审核
    @RequestMapping("ht_jlfolksh")
    public String ht_jlfolksh(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        //查看自己提交的审核番剧
        model.addAttribute("dshfolk",c_folkoperaService.selfolksjyn("待审核"));

        return "/ht/jlfolksh";
    }

}
