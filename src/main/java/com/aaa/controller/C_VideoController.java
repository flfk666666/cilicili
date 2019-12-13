package com.aaa.controller;

import com.aaa.dao.C_selVideoDao;
import com.aaa.entity.*;
import com.aaa.service.*;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("qt")
public class C_VideoController {

    @Resource
    C_VideoService c_videoService;
    @Resource
    C_selVideoDao c_selVideoDao;

    @Resource
    C_selVideoService c_selVideoService;

    @Resource
    C_NewsService c_newsService;
    @Resource
    C_BarrageHistoryService c_barrageHistoryService;
    @Resource
    C_RecentlyService c_recentlyService;
    @Resource
    C_FolkoperaService c_folkoperaService;
    @RequestMapping("index")
    public String queryByVcname(Model model) {
        //最热投稿
        model.addAttribute("musics", c_videoService.queryByVcnamePlaybackValue("音乐"));
        model.addAttribute("games", c_videoService.queryByVcnamePlaybackValue("游戏"));
        model.addAttribute("sciences", c_videoService.queryByVcnamePlaybackValue("科技"));
        model.addAttribute("lifes", c_videoService.queryByVcnamePlaybackValue("生活"));
        model.addAttribute("Advertisements", c_videoService.queryByVcnamePlaybackValue("广告"));
        model.addAttribute("entertainments", c_videoService.queryByVcnamePlaybackValue("娱乐"));
        //最新投稿
        model.addAttribute("musics2", c_videoService.queryByVcnameVtime("音乐"));
        model.addAttribute("games2", c_videoService.queryByVcnameVtime("游戏"));
        model.addAttribute("sciences2", c_videoService.queryByVcnameVtime("科技"));
        model.addAttribute("lifes2", c_videoService.queryByVcnameVtime("生活"));
        model.addAttribute("Advertisements2", c_videoService.queryByVcnameVtime("广告"));
        model.addAttribute("entertainments2", c_videoService.queryByVcnameVtime("娱乐"));
        //热门投稿
        model.addAttribute("musics3", c_videoService.queryByVcnameFabulous("音乐"));
        model.addAttribute("games3", c_videoService.queryByVcnameFabulous("游戏"));
        model.addAttribute("sciences3", c_videoService.queryByVcnameFabulous("科技"));
        model.addAttribute("lifes3", c_videoService.queryByVcnameFabulous("生活"));
        model.addAttribute("Advertisements3", c_videoService.queryByVcnameFabulous("广告"));
        model.addAttribute("entertainments3", c_videoService.queryByVcnameFabulous("娱乐"));
        //查询最新番剧
        model.addAttribute("latestDramas",c_folkoperaService.findAll());
        //查询周一更新的番剧
        model.addAttribute("MondayDramas",c_folkoperaService.findByWorkup("周一"));
        //查询周二更新的番剧
        model.addAttribute("TuesdayDramas",c_folkoperaService.findByWorkup("周二"));
        //查询周三更新的番剧
        model.addAttribute("WednesdayDramas",c_folkoperaService.findByWorkup("周三"));
        //查询周四更新的番剧
        model.addAttribute("ThursdayDramas",c_folkoperaService.findByWorkup("周四"));
        //查询周五更新的番剧
        model.addAttribute("FridayDramas",c_folkoperaService.findByWorkup("周五"));
        //查询周六更新的番剧
        model.addAttribute("SaturdayDramas",c_folkoperaService.findByWorkup("周六"));
        //查询周日更新的番剧
        model.addAttribute("SundayDramas",c_folkoperaService.findByWorkup("周日"));
        //根据点赞数查询番剧排行前8条
        model.addAttribute("Rankings",c_folkoperaService.queryByFabulous());
        //根据播放量查询最热番剧前8条
        model.addAttribute("hottestDramas",c_folkoperaService.queryByPlaybackValue());
        //根据fid查询最新番剧前8条
        model.addAttribute("latestDramas",c_folkoperaService.queryByFid());
        return "qt/index";
    }


    @RequestMapping("selvideo")
    public String selvideo(Model model,int vid,HttpSession session){
        session.removeAttribute("loginvid");
        //查询弹幕
        List<C_Barrage> dmlist=c_selVideoService.seldm(vid);
        //查询视频
        C_Video onevideo=c_selVideoService.selonevideo(vid);
        //根据vid查询up主信息
        C_UserAdmin viduser=c_selVideoService.selviduser(vid);
        //根据vid查询相关推荐
        List<C_tjVideo> xgvadio=c_selVideoService.selxgviedo(vid);
        model.addAttribute("upuser",viduser);
        model.addAttribute("onevideo",onevideo);
        model.addAttribute("dmlist",dmlist);
        int dmsize=dmlist.size();
        model.addAttribute("dmsize",dmsize);
        model.addAttribute("xgvideo",xgvadio);

        return "qt/Video";
    }

    @RequestMapping("seldm")
    @ResponseBody
    public List<C_Barrage> seldm(int vid){

        return c_selVideoService.seldm(vid);
    }

    @RequestMapping("adddm")
    @ResponseBody
    public int adddm(C_Barrage dm,int vid,int uid){


        dm.setSize("1");
        dm.setPosition("0");
        c_selVideoService.adddm(dm);

        int newid=c_selVideoService.newdmid();
        c_selVideoDao.adddmvideo(newid,vid);
        C_BarrageHistory c_barrageHistory=new C_BarrageHistory();
        c_barrageHistory.setId(newid);
        c_barrageHistory.setText(dm.getText());
        c_barrageHistory.setUid(uid);
        c_selVideoDao.adduidolddm(c_barrageHistory);

        return 1;
    }

    //个人中心
    @RequestMapping("Personal")
    public String Personal(Model model,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        //全部消息
        model.addAttribute("allNews",c_newsService.queryByUid(c_userAdmin.getUid()));
        //交易记录
        model.addAttribute("transactionRecords",c_newsService.queryByUidAndType(c_userAdmin.getUid(),"交易记录"));
        //关注记录
        model.addAttribute("attentionNotes",c_newsService.queryByUidAndType(c_userAdmin.getUid(),"关注记录"));
        //系统通知
        model.addAttribute("systemNotifications",c_newsService.queryByUidAndType(c_userAdmin.getUid(),"系统通知"));
        //弹幕记录
        model.addAttribute("barrageRecordings",c_barrageHistoryService.queryByUid(c_userAdmin.getUid()));
        //全部浏览记录
        model.addAttribute("browseRecords",c_recentlyService.queryByUid(c_userAdmin.getUid()));
        //全部视频浏览记录
        model.addAttribute("videos",c_recentlyService.queryByUidAndType(c_userAdmin.getUid(),"视频"));
        //全部番剧浏览记录
        model.addAttribute("folkOperas",c_recentlyService.queryByUidAndType(c_userAdmin.getUid(),"番剧"));
        return "qt/Personal";
    }

    //发弹幕没登录则通过
    @RequestMapping("vidlogin")
    public String vidlogin(int vid,HttpSession session){

        session.setAttribute("loginvid",vid);

        return "qt/login";
    }


}
