package com.aaa.controller;

import com.aaa.config.ipconfig;
import com.aaa.dao.C_selVideoDao;
import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.test.S;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fj")
public class C_selfolkcontroller {


    @Resource
    C_YnFolkReplyService c_ynFolkReplyService;
    @Resource
    C_YnFolkCommentService c_ynFolkCommentService;
    @Resource
    C_FolkCommentService c_folkCommentService;
    @Resource
    C_FolkReplyService c_folkReplyService;
    @Resource
    C_FolkoperaService c_folkoperaService;
    @Resource
    C_selFolkService c_selFolkService;

    @Resource
    C_selVideoService c_selVideoService;
    @Resource
    C_UserAdminService c_userAdminService;
    @Resource
    C_RecentlyService c_recentlyService;
    @Resource
    C_NewsService c_newsService;
    @Resource
    C_ScoringService c_scoringService;
    @Resource
    C_SubscribeService c_subscribeService;
    @Resource
    C_FolkbindingService c_folkbindingService;
    @Resource
    C_VideoService c_videoService;


    @RequestMapping("detailedInformation")
    public String detailedInformation(Integer fid,Model model,HttpSession session){
        session.removeAttribute("loginfid");
        //查看当前番剧信息
        C_Folkopera selfj=c_selFolkService.selfolk(fid);
        //查询番剧全部集数
        List<C_Folknumber> selfjnumber=c_selFolkService.selfolknumber(fid);
        //查看当前番剧
        model.addAttribute("selfj",selfj);
        //查看番剧集数
        model.addAttribute("selfjnumber",selfjnumber);
        //查看番剧追番人数
        model.addAttribute("zfPeople",c_subscribeService.queryCountByFid(fid));
        //查看番剧弹幕总数
        model.addAttribute("TotalnNumberofBarrage",c_folkbindingService.queryBarrageNumByfid(fid));

        //查询番剧相关推荐
        List<Map<String,Object>> selxgfolk=c_selFolkService.selxgfolk(fid);
        model.addAttribute("selxgfolk",selxgfolk);
        //查询番剧相关视频
        model.addAttribute("videos",c_videoService.queryByVcnameVtime("生活"));
        //查询音乐全部视频(最热)
        model.addAttribute("musics",c_selVideoService.selallflvideo(1));



        //新加
        //查看番剧点评
        model.addAttribute("folkalldp",c_scoringService.selfjzxScoring(fid));
        //查看番剧平均评分
        if (c_scoringService.selScoring(fid).size()>2){
            Integer avgpf=c_folkoperaService.selavgpf(fid);
            model.addAttribute("avgpf",avgpf);
        }else {
            model.addAttribute("avgpf","暂无");
        }





        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");
        if (null!=user){
            C_Subscribe selzfyn=c_selFolkService.selfjyn(user.getUid(),fid);
            if (null!=selzfyn){
                model.addAttribute("fjyn","已追番");

            }else{
                model.addAttribute("fjyn","追番");

            }
        }
        return "qt/fjzx";
    }


    @RequestMapping("selonefj")
    public String selonefj(int fid,@RequestParam(defaultValue ="1")int fnumber,Model model,HttpSession session){
        session.removeAttribute("loginfid");
        session.removeAttribute("loginfnumber");

        int fplayyn=c_userAdminService.selfolkip(ipconfig.getip(),fid);
        if (fplayyn==0){
            c_userAdminService.addipfolk(ipconfig.getip(),fid);
            c_userAdminService.upfolkpaly(fid);
        }


        //查询追番
        model.addAttribute("zfcount",c_folkoperaService.selzfcount(fid));
        //查看当前番剧信息
        C_Folkopera selfj=c_selFolkService.selfolk(fid);
        //查询番剧全部集数
        List<C_Folknumber> selfjnumber=c_selFolkService.selfolknumber(fid);
        //查询番剧当前集数信息
        C_Folknumber selfjonenumber=c_selFolkService.selfonenumber(fid,fnumber);
        //查询番剧当前弹幕
        List<C_Barrage> fjdm=c_selFolkService.selfolkdm(fid, fnumber);
        //查询番剧相关推荐
        List<Map<String,Object>> selxgfolk=c_selFolkService.selxgfolk(fid);
        //判断是否追番
        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");
        //根据fid查找点评
        model.addAttribute("folkalldp",c_scoringService.selScoring(fid));

        if (c_scoringService.selScoring(fid).size()>2){
            Integer avgpf=c_folkoperaService.selavgpf(fid);
            model.addAttribute("avgpf",avgpf);
        }else {
            model.addAttribute("avgpf","暂无");
        }


        C_Scoring userdpyn=null;
        if (null!=user){
            //判断是否点评
            userdpyn=c_scoringService.seldpyn(fid,user.getUid());

            //添加浏览记录
            C_Recently c_recently=new C_Recently();
            c_recently.setId(selfjonenumber.getFid());
            c_recently.setVideotitle(selfj.getFname());
            c_recently.setVideocover(selfj.getFolkcover());
            c_recently.setIntroductio(selfj.getFolkintroduction());
            c_recently.setDatetime(new Date());
            c_recently.setType("番剧");
            c_recently.setSetNumber(fnumber);
            c_recently.setUid(user.getUid());

            //判断视频是否存在
            int pdfjcz=c_recentlyService.pdRecently(selfjonenumber.getFid(),"番剧",user.getUid());
            if(pdfjcz>0){
                c_recentlyService.delRecently(selfjonenumber.getFid(),"番剧",user.getUid());
                c_recentlyService.addRecently(c_recently);
            }else {
                c_recentlyService.addRecently(c_recently);
            }



            C_Subscribe selzfyn=c_selFolkService.selfjyn(user.getUid(),fid);
            if (null!=selzfyn){
               model.addAttribute("fjyn","取消");

            }else{
                model.addAttribute("fjyn","追番");

            }
        }else{
            model.addAttribute("fjlogin",1);

        }
        model.addAttribute("userdpyn",userdpyn);


        //查看当前番剧
        model.addAttribute("selfj",selfj);
        //查看番剧集数
        model.addAttribute("selfjnumber",selfjnumber);
        //查询番剧当前集数信息
        model.addAttribute("fjnumber",selfjonenumber);
        //查询番剧当前弹幕
        model.addAttribute("fjdm",fjdm);
        //统计番剧弹幕总数
        model.addAttribute("fjdmsize",c_selFolkService.folkdmcount(fid));
        //查询番剧相关推荐
        model.addAttribute("selxgfolk",selxgfolk);

        //查询番剧评论
        model.addAttribute("PanDramaReviews", c_folkCommentService.queryByfid(fid));
        Integer reviews = c_ynFolkReplyService.queryReviewsByFid(fid);
        if(null==reviews || "".equals(reviews)){
            reviews=0;
        }
        model.addAttribute("reviews",reviews);
        //查询未上架的番剧
        model.addAttribute("Notonshelves",c_folkoperaService.queryNotonshelves());


        return "qt/Playtime";
    }

    @RequestMapping("selfolkdm")
    @ResponseBody
    public List<C_Barrage> selfolkdm(int fid,int fnumber){
        return c_selFolkService.selfolkdm(fid, fnumber);
    }




    @RequestMapping("adddm")
    @ResponseBody
    public int adddm(C_Barrage dm,int uid,int fid,int fnumber){
        //添加弹幕
        dm.setSize("1");
        dm.setPosition("0");
        c_selVideoService.adddm(dm);
        //查询此弹幕id
       int maxdmid=c_selVideoService.newdmid();
       //添加弹幕历史记录
        C_BarrageHistory c_barrageHistory=new C_BarrageHistory();
        c_barrageHistory.setId(maxdmid);
        c_barrageHistory.setUid(uid);
        c_barrageHistory.setText(dm.getText());

        c_selVideoService.adduidolddm(c_barrageHistory);
       //添加弹幕与番剧关联关系
        C_Folkbinding fk=new C_Folkbinding();

        fk.setId(maxdmid);
        fk.setFid(fid);
        fk.setFnumber(fnumber);
        c_selFolkService.adddmfolk(fk);
        return 1;
    }


    //发弹幕没登录则通过
    @RequestMapping("fidlogin")
    public String vidlogin(int fid,int fnumber, HttpSession session){

        session.setAttribute("loginfid",fid);
        session.setAttribute("loginfnumber",fnumber);

        return "qt/login";
    }


    @RequestMapping("flogin")
    public String flogin(Integer fid,HttpSession session){
        session.setAttribute("loginfid",fid);
        return "qt/login";
    }

    //追番
    @RequestMapping("zf")
    public String zffolk(C_Subscribe c_subscribe,Integer fnumber){
        c_subscribe.setOpenYN("0");
        c_selFolkService.zffolk(c_subscribe);
        if(fnumber!=null){
            return "redirect:/fj/selonefj?fid="+c_subscribe.getFid()+"&&fnumber="+fnumber;
        }
        return "redirect:/fj/detailedInformation?fid="+c_subscribe.getFid();
    }

    //取消追番
    @RequestMapping("qxzf")
    public String zffolk(int fid,int uid,Integer fnumber){
        c_selFolkService.delzffolk(fid, uid);
        if(fnumber!=null){
            return "redirect:/fj/selonefj?fid="+fid+"&&fnumber="+fnumber;
        }
        return "redirect:/fj//detailedInformation?fid="+fid;
    }



    //打赏番剧
    @RequestMapping("folkds")
    public String folkds(int fid,int fnumber,int uid,int dscb,int sycb,HttpSession session){
        C_News c_news=new C_News();
        c_news.setType("交易记录");
        c_news.setDatetime(new Date());
        c_news.setUid(uid);
        c_news.setNcontext("您打赏消费了"+dscb+"C币,剩余"+(sycb-dscb)+"C币");
        c_newsService.Recharge(c_news);
        c_userAdminService.updatejsCCoin(uid,dscb);
        session.setAttribute("userAdmin", c_userAdminService.selone(uid));

        return "redirect:/fj/selonefj?fid="+fid+"&&fnumber="+fnumber;
    }


    //更新短评
    @RequestMapping("userpysubmit")
    public String userpysubmit(C_Scoring c_scoring,int fid,int fnumber){

        c_scoring.setVtime(new Date());

        c_scoringService.addscoring(c_scoring);



        return "redirect:/fj/selonefj?fid="+fid+"&&fnumber="+fnumber;
    }


    //番剧评论
    @RequestMapping("PanDramaReview")
    @ResponseBody
    public int PanDramaReview(C_FolkComment c_folkComment){
        c_folkComment.setDatetime(new Date());
        c_folkComment.setGood(0);
        c_folkCommentService.add(c_folkComment);
        return 1;
    }

    //番剧回复评论
    @RequestMapping("ReplytoComments")
    @ResponseBody
    public int ReplytoComments(C_FolkReply c_folkReply){
        c_folkReply.setDatetime(new Date());
        c_folkReply.setGood(0);
        c_folkReplyService.add(c_folkReply);
        return 1;
    }

    //点赞番剧评论
    @RequestMapping("likeFolkComment")
    @ResponseBody
    public int likeFolkComment(C_YnFolkComment c_ynFolkComment){
        c_ynFolkCommentService.add(c_ynFolkComment);
        c_folkCommentService.updateGood(c_ynFolkComment.getFcid());
        return 1;
    }

    //点赞番剧评论的回复
    @RequestMapping("likeFolkCommentReply")
    @ResponseBody
    public int likeFolkCommentReply(C_YnFolkReply c_ynFolkReply){
        c_ynFolkReplyService.add(c_ynFolkReply);
        c_folkReplyService.updateGood(c_ynFolkReply.getFrid());
        return 1;
    }
    //判断是否点赞过评论的回复
    @RequestMapping("ynFolkCommentReplys")
    @ResponseBody
    public int ynFolkCommentReplys(C_YnFolkReply c_ynFolkReply){
        C_YnFolkReply ynFolkReply = c_ynFolkReplyService.queryByUidFrid(c_ynFolkReply.getUid(), c_ynFolkReply.getFrid());
        if(null !=ynFolkReply){
            return 1;
        }
        return 0;
    }
    //判断是否点赞过该评论
    @RequestMapping("YnFolkComments")
    @ResponseBody
    public int YnFolkComments(C_YnFolkComment c_ynFolkComment){
        C_YnFolkComment ynFolkComment = c_ynFolkCommentService.findByUidFcid(c_ynFolkComment.getUid(), c_ynFolkComment.getFcid());
        if(null !=ynFolkComment){
            return 1;
        }
        return 0;
    }




}
