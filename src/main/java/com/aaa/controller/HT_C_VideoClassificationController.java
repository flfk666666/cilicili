package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_Video;
import com.aaa.entity.C_VideoClassification;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_VideoClassificationService;
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
@RequestMapping("ht_videoclassification")
public class HT_C_VideoClassificationController {
    @Resource
    HT_C_VideoClassificationService ht_c_videoClassificationService;
    @Resource
    HT_C_listService ht_c_listService;
    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/videoclassification";
    }

    @RequestMapping("c_page")
    @ResponseBody
    public Epage<C_VideoClassification> epage(Integer page, Integer rows){
        return ht_c_videoClassificationService.findAllPage(page,rows);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Integer vfid){
        ht_c_videoClassificationService.Delete(vfid);
        return ht_c_videoClassificationService.Delete(vfid);
    }
}
