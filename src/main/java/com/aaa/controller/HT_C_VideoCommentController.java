package com.aaa.controller;

import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_Video;
import com.aaa.entity.C_VideoComment;
import com.aaa.entity.C_list;
import com.aaa.service.HT_C_VideoCommentService;
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
@RequestMapping("c_videocomment")
public class HT_C_VideoCommentController {
    @Resource
    HT_C_VideoCommentService ht_c_videoCommentService;

    @Resource
    HT_C_listService ht_c_listService;
    @RequestMapping("ht_list_show")
    public String ht_list_show(Model model){
        //获取当前登录用户
        C_UserAdmin c_userAdmin=(C_UserAdmin) SecurityUtils.getSubject().getPrincipal();
        List<C_list> ht_list=ht_c_listService.ht_findAll(c_userAdmin.getUid());
        model.addAttribute("ht_list",ht_list);
        return "/ht/videocomment";
    }
    //查询所有视频评论
    @RequestMapping("VfindAll")
    @ResponseBody
    public List<Map<String,Object>>VfindAll(){
        return ht_c_videoCommentService.VfindAll();
    }
    //删除视频评论
    @RequestMapping("delete")
    @ResponseBody
    public int delete1(Integer vcid){
        return ht_c_videoCommentService.delete(vcid);
    }
    //分页
    @RequestMapping("c_page")
    @ResponseBody
    public Epage<C_VideoComment> epage(Integer page, Integer rows){
        return ht_c_videoCommentService.findAllPage(page,rows);
    }
}
