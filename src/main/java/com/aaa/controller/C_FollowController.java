package com.aaa.controller;

import com.aaa.entity.C_Follow;
import com.aaa.entity.C_News;
import com.aaa.entity.C_UserAdmin;
import com.aaa.service.C_FollowService;
import com.aaa.service.C_NewsService;
import com.aaa.service.C_UserAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("follow")
public class C_FollowController {
    @Resource
    C_FollowService c_followService;
    @Resource
    C_NewsService c_newsService;
    @Resource
    C_UserAdminService c_userAdminService;

    @RequestMapping("gz")
    public String gzfollow(C_Follow c_follow,int vid){
        c_followService.addfollow(c_follow);
        String fuidname=c_userAdminService.selone(c_follow.getFuid()).getAlias();
        C_News news=new C_News();
        news.setNcontext("您关注了:"+fuidname);
        news.setDatetime(new Date());
        news.setType("关注记录");
        news.setUid(c_follow.getUid());
        c_newsService.Recharge(news);
        return "redirect:/qt/selvideo?vid="+vid;
    }
    @RequestMapping("qg")
    public String qgfollow(C_Follow c_follow,int vid){
        c_followService.delfollow(c_follow);
        String fuidname=c_userAdminService.selone(c_follow.getFuid()).getAlias();
        C_News news=new C_News();
        news.setNcontext("您取关了:"+fuidname);
        news.setDatetime(new Date());
        news.setType("关注记录");
        news.setUid(c_follow.getUid());
        c_newsService.Recharge(news);
        return "redirect:/qt/selvideo?vid="+vid;
    }

    @RequestMapping("grqg")
    public String grqgfollow(int fuid, HttpSession session){
        C_Follow follow=new C_Follow();
        follow.setFuid(fuid);
        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");
        follow.setUid(user.getUid());
        c_followService.delfollow(follow);
        return "redirect:/qt_C_User/goPersonalspace?uid="+user.getUid();
    }





}
