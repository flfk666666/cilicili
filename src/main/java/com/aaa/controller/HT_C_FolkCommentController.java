package com.aaa.controller;

import com.aaa.entity.C_FolkComment;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_VideoComment;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C__FolkCommentService;
import com.aaa.service.HT_C_listService;
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
@RequestMapping("c_folkcomment")
public class HT_C_FolkCommentController {
    @Resource
    HT_C__FolkCommentService ht_c__folkCommentService;
    @Resource
    HT_C_listService ht_c_listService;
    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/folkcomment";
    }
   //查询番剧评论所有
    @RequestMapping("FfindAll")
    @ResponseBody
    public List<Map<String,Object>>FfindAll(){
        return ht_c__folkCommentService.FfindAll();
    }
  //删除番剧评论
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Integer fcid){
        return ht_c__folkCommentService.deletea(fcid);
    }
    @RequestMapping("c_page")
    @ResponseBody
    public Epage<C_FolkComment> epage(Integer page, Integer rows){
        return ht_c__folkCommentService.findAllPage(page,rows);
    }
}
