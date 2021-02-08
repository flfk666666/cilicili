package com.aaa.controller;

import com.aaa.entity.C_CollectionVideo;
import com.aaa.entity.C_News;
import com.aaa.entity.C_Subscribe;
import com.aaa.entity.C_UserAdmin;
import com.aaa.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("qt_C_User")
public class C_UserAdminController {

    @Resource
    C_UserAdminService c_userAdminService;
    @Resource
    C_CollectionVideoService c_collectionVideoService;
    @Resource
    C_SubscribeService c_subscribeService;
    @Resource
    C_FollowService c_followService;
    @Resource
    C_VideoService c_videoService;
    @Resource
    C_NewsService c_newsService;


    @RequestMapping("login")
    public String login(String uname, String pwd, HttpSession session){
        C_UserAdmin userAdmin = c_userAdminService.login(uname, pwd);
        if(null==userAdmin){
            session.setAttribute("msg","用户名或密码错误");
            return "/qt/login";
        }else {
            if(userAdmin.getState().equals("禁用")){
                session.setAttribute("msg","该用户已禁用");
                return "/qt/login";
            }else {
                C_News c_news=new C_News();
                c_news.setNcontext("登录成功经验+5");
                c_news.setDatetime(new Date());
                c_news.setType("系统记录");
                c_news.setUid(userAdmin.getUid());
                c_newsService.Recharge(c_news);
            }

            session.setAttribute("userAdmin",userAdmin);
        }
        return "redirect:/qt/index";
    }

    @RequestMapping("register")
    @ResponseBody
    public int register(C_UserAdmin c_userAdmin){
        c_userAdmin.setIdentity("普通用户");
        c_userAdmin.setGrade(1);
        c_userAdmin.setEmpirical(0);
        c_userAdmin.setCCoin(2);
        c_userAdmin.setState("正常");
        c_userAdmin.setHeadimg("morentouxiang.jpg");
        c_userAdmin.setSpaceimg("img/beijing1.png");
        c_userAdmin.setPersonalized("默认签名");
        c_userAdmin.setPaymentpwd("123456");
        return c_userAdminService.register(c_userAdmin);
    }

    //进入个人空间
    @RequestMapping("goPersonalspace")
    public String goPersonalspace(Model model,int uid,HttpSession session){
        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");

        model.addAttribute("userVideos",c_videoService.queryByUid(uid));

        model.addAttribute("dzvideo",c_userAdminService.medzvideo(uid));


        model.addAttribute("userzdvideo",c_userAdminService.seluserzd(uid));



        if (null!=user){
            if(user.getUid()==uid){
                C_UserAdmin c_userAdmin=c_userAdminService.selone(uid);
                List<C_Subscribe> selsub=c_subscribeService.selsub(uid);
                //我的粉丝
                List<C_UserAdmin> selwdfs=c_followService.selwdfs(uid);
                //我的关注
                List<C_UserAdmin> selwdgz=c_followService.selwdgz(uid);

                model.addAttribute("wdfs",selwdfs);
                model.addAttribute("wdfssize",selwdfs.size());
                model.addAttribute("wdgz",selwdgz);
                model.addAttribute("wdgzsize",selwdgz.size());
                model.addAttribute("selsub",selsub);
                model.addAttribute("userspace",c_userAdmin);


                model.addAttribute("trkj",0);

                //查询收藏文件夹
                List<C_CollectionVideo> selcoll=c_collectionVideoService.selcollvideo(uid);
                model.addAttribute("selcoll",selcoll);
                int i=1;
                for (C_CollectionVideo c: selcoll) {

                    List<C_CollectionVideo> seltypevideo=c_collectionVideoService.seltype(c.getUid(),c.getType());
                    String tc="tc";
                    model.addAttribute("tc"+i,seltypevideo);
                    i=i+1;

                }
            }else {
                C_UserAdmin c_userAdmin=c_userAdminService.selone(uid);
                List<C_Subscribe> selsub=c_subscribeService.selsub(uid);
                //我的粉丝
                List<C_UserAdmin> selwdfs=c_followService.selwdfs(uid);
                //我的关注
                List<C_UserAdmin> selwdgz=c_followService.selwdgz(uid);

                model.addAttribute("wdfs",selwdfs);
                model.addAttribute("wdfssize",selwdfs.size());
                model.addAttribute("wdgz",selwdgz);
                model.addAttribute("wdgzsize",selwdgz.size());
                model.addAttribute("selsub",selsub);
                model.addAttribute("userspace",c_userAdmin);

                model.addAttribute("trkj",1);

                //查询收藏文件夹
                List<C_CollectionVideo> selcoll=c_collectionVideoService.seltrcollvideo(uid);
                model.addAttribute("selcoll",selcoll);
                int i=1;
                for (C_CollectionVideo c: selcoll) {

                    List<C_CollectionVideo> seltypevideo=c_collectionVideoService.seltype(c.getUid(),c.getType());
                    String tc="tc";
                    model.addAttribute("tc"+i,seltypevideo);
                    i=i+1;

                }
            }
        }else {
            C_UserAdmin c_userAdmin=c_userAdminService.selone(uid);
            List<C_Subscribe> selsub=c_subscribeService.selsub(uid);
            //我的粉丝
            List<C_UserAdmin> selwdfs=c_followService.selwdfs(uid);
            //我的关注
            List<C_UserAdmin> selwdgz=c_followService.selwdgz(uid);

            model.addAttribute("wdfs",selwdfs);
            model.addAttribute("wdfssize",selwdfs.size());
            model.addAttribute("wdgz",selwdgz);
            model.addAttribute("wdgzsize",selwdgz.size());
            model.addAttribute("selsub",selsub);
            model.addAttribute("userspace",c_userAdmin);

            model.addAttribute("trkj",1);

            //查询收藏文件夹
            List<C_CollectionVideo> selcoll=c_collectionVideoService.selcollvideo(uid);
            model.addAttribute("selcoll",selcoll);
            int i=1;
            for (C_CollectionVideo c: selcoll) {

                List<C_CollectionVideo> seltypevideo=c_collectionVideoService.seltype(c.getUid(),c.getType());
                String tc="tc";
                model.addAttribute("tc"+i,seltypevideo);
                i=i+1;

            }
        }




        return "/qt/Personalspace";
    }

    @RequestMapping("zx")
    public String zx(HttpSession session){
        session.removeAttribute("userAdmin");
        return "redirect:/qt/index";
    }




    //修改空间宣言
    @RequestMapping("updateSpacedeclaration")
    @ResponseBody
    public int updateSpacedeclaration(String con,HttpSession session){
        C_UserAdmin c_userAdminOld=(C_UserAdmin)session.getAttribute("userAdmin");
        Integer uid=c_userAdminOld.getUid();
        c_userAdminService.updateSpacedeclaration(uid,con);
        session.setAttribute("userAdmin",c_userAdminService.selone(uid));
        return 1;
    }

    //修改空间宣言
    @RequestMapping("updatePersonalized")
    @ResponseBody
    public int updatePersonalized(String Personalized,HttpSession session){
        C_UserAdmin c_userAdminOld=(C_UserAdmin)session.getAttribute("userAdmin");
        Integer uid=c_userAdminOld.getUid();
        c_userAdminService.updatePersonalized(uid,Personalized);
        session.setAttribute("userAdmin",c_userAdminService.selone(uid));
        return 1;
    }

    //取消收藏
    @RequestMapping("delsc")
    public String delsc(int vid,int uid){
        c_collectionVideoService.delcollvideo(vid,uid);

        return "redirect:/qt_C_User/goPersonalspace?uid="+uid;
    }

    //修改收藏视频状态
    @RequestMapping("upcolltype")
    public String upcolltype(int type,int uid,int vid){
        c_collectionVideoService.upcolltype(type, uid, vid);
        return "redirect:/qt_C_User/goPersonalspace?uid="+uid;
    }

    //取消置顶
    @RequestMapping("qxzd")
    public String qxzd(int z_index,int uid,int vid){
        if(z_index==1){
            c_userAdminService.upallvideo(uid);
            c_userAdminService.upzdvideo(z_index,vid);
        }else {
            c_userAdminService.upzdvideo(z_index,vid);
        }

        return "redirect:/qt_C_User/goPersonalspace?uid="+uid;
    }

    //修改文件夹名称
    @RequestMapping("xgwjj")
    public String xgwjj(String uptype,String upcvid,int uid){
        
        c_collectionVideoService.upcolltypename(uptype, upcvid);
        return "redirect:/qt_C_User/goPersonalspace?uid="+uid;
    }

}
