package com.aaa.controller;

import com.aaa.config.ipconfig;
import com.aaa.dao.C_selVideoDao;
import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.test.S;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("qt")
public class C_VideoController {
    //保存上传的图片和视频信息
    Map<String,Object> map=new HashMap<>();
    //保存上传的用户头像信息
    Map<String,Object> mapImg=new HashMap<>();


    @Resource
    C_FolkshoppingService c_folkshoppingService;
    @Resource
    C_YncomreplyGoodService c_yncomreplyGoodService;
    @Resource
    C_ComyngoodService c_comyngoodService;
    @Resource
    C_VideoReplyService c_videoReplyService;
    @Resource
    C_VideoCommentService c_videoCommentService;
    @Resource
    C_VideoService c_videoService;
    @Resource
    C_selVideoDao c_selVideoDao;
    @Resource
    C_RecordawardService c_recordawardService;
    @Resource
    C_selVideoService c_selVideoService;
    @Resource
    C_VideoClassificationService c_videoClassificationService;
    @Resource
    C_NewsService c_newsService;
    @Resource
    C_BarrageHistoryService c_barrageHistoryService;
    @Resource
    C_RecentlyService c_recentlyService;
    @Resource
    C_FolkoperaService c_folkoperaService;
    @Resource
    C_CreatoramountService c_creatoramountService;
    @Resource
    C_CollectionVideoService c_collectionVideoService;
    @Resource
    C_FollowService c_followService;
    @Resource
    C_UserAdminService c_userAdminService;


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
        //查询点赞量倒叙视频前6条
        model.addAttribute("PraisePoints",c_videoService.queryByFabulous());
        //查询分类为广告，按点赞数倒叙前4条
        model.addAttribute("AdvertisingVideos",c_videoService.queryByFabulousAndVfid());
        //查询广告
        model.addAttribute("amentindex",c_userAdminService.selament("首页"));
        //查询每个视频分类的数量
        model.addAttribute("cates",c_videoService.queryCateNum());

        return "qt/index";
    }


    @RequestMapping("fjindex")
    public String fjindex(int vfid,Model model) {


        //查询出对应
        model.addAttribute("flname",c_selVideoService.selvideoclass(vfid));
        //最热排行前十
        model.addAttribute("topvideo",c_selVideoService.seltopflvideo(vfid));
        //类别headtop6
        model.addAttribute("headvideo",c_selVideoService.selheadflvideo(vfid));
        //查询分类视频全部(最热)
        model.addAttribute("allvideo",c_selVideoService.selallflvideo(vfid));
        //查询分类视频全部(最新)
        model.addAttribute("newvideo",c_selVideoService.selnewflvideo(vfid));

        //查询分类为广告，按点赞数倒叙前4条
        model.addAttribute("AdvertisingVideos",c_videoService.queryByFabulousAndVfid());

        //查询每个视频分类的数量
        model.addAttribute("cates",c_videoService.queryCateNum());

        return "qt/flindex";
    }

    @RequestMapping("folkindex")
    public String folkindex(Model model) {

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
        //根据点赞数查询番剧排行前10条
        model.addAttribute("Rankings",c_folkoperaService.queryByFabulous());
        //根据热度查询所有
        model.addAttribute("hottestDramas",c_folkoperaService.selpalayallfolk());
        //根据时间查询全部
        model.addAttribute("latestDramas",c_folkoperaService.selnewallfolk());

        //查询分类为广告，按点赞数倒叙前4条
        model.addAttribute("AdvertisingVideos",c_videoService.queryByFabulousAndVfid());

        //查询每个视频分类的数量
        model.addAttribute("cates",c_videoService.queryCateNum());

        return "qt/folkindex";
    }

    @RequestMapping("upload2")
    @ResponseBody
    public Map<String,Object> upload2(@RequestParam(name = "file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        System.out.println("filename = " + filename);
        if(!"".equals(filename)){
            String savePath="F:/B站视频/biliTx/"+filename.substring(filename.lastIndexOf("\\")+1);
            File saveFile=new File(savePath);
            // 另存为
            file.transferTo(saveFile);
        }
        mapImg.put("code",0);
        mapImg.put("img",filename.substring(filename.lastIndexOf("\\")+1));
        return mapImg;
    }
    //修改用户信息
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public int updateUserInfo(C_UserAdmin c_userAdmin,HttpSession session){
        C_UserAdmin c_userAdminOld=(C_UserAdmin)session.getAttribute("userAdmin");
        c_userAdminOld.setSex(c_userAdmin.getSex());
        c_userAdminOld.setAlias(c_userAdmin.getAlias());
        c_userAdminOld.setPersonalized(c_userAdmin.getPersonalized());
        if(null!=mapImg.get("img")){
            String img=mapImg.get("img").toString();
            c_userAdminOld.setHeadimg(img);
        }
        System.out.println("c_userAdmin = " + c_userAdminOld);
        session.setAttribute("userAdmin",c_userAdminOld);
        return c_userAdminService.updateUserInfo(c_userAdminOld);
    }


    @RequestMapping("selvideo")
    public String selvideo(Model model,int vid,HttpSession session){
        session.removeAttribute("loginvid");
        model.addAttribute("amentvideo",c_userAdminService.selament("视频"));

        //判断是否访问过
        int ipyn=c_userAdminService.selvideoip(ipconfig.getip(),vid);
        if(ipyn==0){
            c_userAdminService.addipvideo(ipconfig.getip(),vid);
            c_userAdminService.upvideopaly(vid);
        }


        //查询弹幕
        List<C_Barrage> dmlist=c_selVideoService.seldm(vid);
        //查询视频
        C_Video onevideo=c_selVideoService.selonevideo(vid);
        //根据vid查询up主信息
        C_UserAdmin viduser=c_selVideoService.selviduser(vid);
        //根据vid查询相关推荐
        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");






        if (null!=user){
            //查询是否打赏过
            int selrecordyn=c_recordawardService.selrecordyn(vid,user.getUid());
            model.addAttribute("selrecordyn",selrecordyn);



            //视频赋值
            //添加浏览记录
            C_Recently c_recently=new C_Recently();
            c_recently.setId(onevideo.getVid());
            c_recently.setVideotitle(onevideo.getVname());
            c_recently.setVideocover(onevideo.getVideocover());
            c_recently.setIntroductio(onevideo.getVideointroduction());
            c_recently.setDatetime(new Date());
            c_recently.setType("视频");
            c_recently.setSetNumber(0);
            c_recently.setUid(user.getUid());

            //判断视频是否存在
            int pdvideocz=c_recentlyService.pdRecently(onevideo.getVid(),"视频",user.getUid());
            if(pdvideocz>0){
                c_recentlyService.delRecently(onevideo.getVid(),"视频",user.getUid());
                c_recentlyService.addRecently(c_recently);
            }else {
                c_recentlyService.addRecently(c_recently);
            }




           C_CollectionVideo selscyn=c_collectionVideoService.selcoll(vid,user.getUid());
            //查询收藏类型
            List<C_CollectionVideo> selcollvideo=c_collectionVideoService.selcollvideo(user.getUid());
            model.addAttribute("collvideo",selcollvideo);
            //判断是否关注此up主
            C_Follow selfollowyn=c_followService.selfollowyn(user.getUid(),viduser.getUid());
            //判断是否点赞
            int insdz=c_videoService.seldzyn(user.getUid(),vid);

            model.addAttribute("insdz",insdz);
            if (null!=selfollowyn){
                model.addAttribute("fsyn","取关");
            }else {
                model.addAttribute("fsyn","关注");
            }
            if (null!=selscyn){
                model.addAttribute("fjyn","取消收藏");

            }else{
                model.addAttribute("fjyn","收藏");

            }
        }else{
            model.addAttribute("splogin",1);
            model.addAttribute("insdz",0);
        }





        List<C_tjVideo> xgvadio=c_selVideoService.selxgviedo(vid);
        model.addAttribute("upuser",viduser);
        model.addAttribute("onevideo",onevideo);
        model.addAttribute("dmlist",dmlist);
        int dmsize=dmlist.size();
        model.addAttribute("dmsize",dmsize);
        model.addAttribute("xgvideo",xgvadio);

        //查询该视频下的评论
        model.addAttribute("VideoCommens",c_videoCommentService.queryByVid(vid));
        //查询该视频的总评论
        Integer VideoGeneralComments=c_videoCommentService.queryGeneralCommentByVid(vid);
        if(null ==VideoGeneralComments || "".equals(VideoGeneralComments)){
            VideoGeneralComments=0;
        }
        model.addAttribute("VideoGeneralComments",VideoGeneralComments);


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

    //进入充值中心
    @RequestMapping("Voucher")
    public String Voucher(){
        return "qt/Voucher";
    }
    //进入交易记录
    @RequestMapping("Voucher_news")
    public String Voucher_news(Model model,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        //查询充值明细
        model.addAttribute("rechargeDetails",c_newsService.queryByUidAndTypeAndCon(c_userAdmin.getUid(),"交易记录","充值"));
        //查询消费明细
        model.addAttribute("consumptionDetails",c_newsService.queryByUidAndTypeAndCon(c_userAdmin.getUid(),"交易记录","消费"));
        return "qt/Voucher_news";
    }


    @RequestMapping("addsc")
    public String addsc(C_CollectionVideo c_collectionVideo, String yysc,String zdysc){

        if (zdysc!=""){
            c_collectionVideo.setType(zdysc);
        }else {
            c_collectionVideo.setType(yysc);
        }
        c_collectionVideo.setDatetime(new Date());
        c_collectionVideo.setOpenYN("0");
        c_collectionVideoService.addcollvideo(c_collectionVideo);


        return "redirect:/qt/selvideo?vid="+c_collectionVideo.getVid();
    }

    @RequestMapping("delsc")
    public String delsc(int vid,int uid){
        c_collectionVideoService.delcollvideo(vid,uid);

        return "redirect:/qt/selvideo?vid="+vid;
    }

    @RequestMapping("adddz")
    public String adddz(int vid,HttpSession session){
        C_UserAdmin user=(C_UserAdmin) session.getAttribute("userAdmin");
        c_videoService.insdz(user.getUid(),vid);
        c_videoService.addbfl(vid);
        return "redirect:/qt/selvideo?vid="+vid;
    }


    @RequestMapping("Creative")
    public String Creative(Model model,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        //查询用户视频
        model.addAttribute("userVideos",c_videoService.queryByUid(c_userAdmin.getUid()));
        //查询所有分类
        model.addAttribute("cates",c_videoClassificationService.query());
        //查询用户获赏总金额
        Integer TotalAmountofReward = c_recordawardService.queryTotalMoneyByUid(c_userAdmin.getUid());
        if(null==TotalAmountofReward){
            model.addAttribute("TotalAmountofReward",0);
        }else{
            model.addAttribute("TotalAmountofReward",TotalAmountofReward);
        }
        //查询用户获赏记录
        model.addAttribute("RecordofAwards",c_recordawardService.queryByUid(c_userAdmin.getUid()));
        Integer TotalPlaybackVolume=c_videoService.queryPlaybackValueByUid(c_userAdmin.getUid());
        if(null==TotalPlaybackVolume){
            //查询用户视频总播放量
            model.addAttribute("TotalPlaybackVolume",0);
        }else{
            //查询用户视频总播放量
            model.addAttribute("TotalPlaybackVolume",c_videoService.queryPlaybackValueByUid(c_userAdmin.getUid()));
        }
        Integer TotalWithdrawalAmount=c_creatoramountService.queryTotalMoneyByUid(c_userAdmin.getUid());
        if(null==TotalWithdrawalAmount){
            //查询用户已提现总金额
            model.addAttribute("TotalWithdrawalAmount",0);
        }else {
            //查询用户已提现总金额
            model.addAttribute("TotalWithdrawalAmount",c_creatoramountService.queryTotalMoneyByUid(c_userAdmin.getUid()));
        }
        //查询用户提现记录
        model.addAttribute("WithdrawalsRecords",c_creatoramountService.queryByUid(c_userAdmin.getUid()));
        //查询用户数据
        model.addAttribute("data",c_userAdminService.queryDataByUid(c_userAdmin.getUid()));
        //查询用户评论数量
        Integer reviewCount=c_userAdminService.queryReviewCountByUid(c_userAdmin.getUid());
        model.addAttribute("reviewCount",reviewCount);
        return "qt/Creative";
    }

    //用户删除视频
    @RequestMapping("delVideo")
    @ResponseBody
    public int delVidelByUidVid(Integer vid,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_videoService.updateVideoState(c_userAdmin.getUid(),vid);
        return 1;
    }

    //用户发布视频
    @RequestMapping("UploadVideo")
    @ResponseBody
    public int UploadVideo(C_Video c_video,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        String cover = map.get("cover").toString();
        String path = map.get("path").toString();
        c_video.setUid(c_userAdmin.getUid());
        c_video.setVideocover(cover);
        c_video.setContext(path);
        c_video.setState("0");
        c_video.setZ_index("0");
        c_video.setFabulous(0);
        c_video.setPlaybackValue(0);
        c_video.setVtime(new Date());
        map.remove("cover");
        map.remove("path");
        return c_videoService.ReleaseVideo(c_video);
    }
    //用户上传文件
    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam(name = "file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        System.out.println("filename = " + filename);
        if(!"".equals(filename)){
            String savePath="F:\\B站视频\\bilibiliVideo\\"+filename;
            File saveFile=new File(savePath);
            // 另存为
            file.transferTo(saveFile);
        }
        map.put("code",0);
        if(filename.indexOf(".")!=-1){
            if("mp4".equals(filename.substring(filename.lastIndexOf(".")+1))){
                map.put("path",filename);
            }else{
                map.put("cover",filename);
            }
        }
        for(String a:map.keySet()){
            System.out.println(a+"==="+map.get(a));
        }
        return map;
    }

    //创作者提现
    @RequestMapping("CashWithdrawal")
    @ResponseBody
    public int CashWithdrawal(C_Creatoramount c_creatoramount,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_creatoramount.setVtime(new Date());
        c_creatoramount.setUid(c_userAdmin.getUid());
        return c_creatoramountService.add(c_creatoramount);
    }

    //用户提现
    @RequestMapping("UserWithdrawals")
    @ResponseBody
    public int UserWithdrawals(String moneys,String tmodes,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        //减少C币
        c_userAdminService.updateCCoin(c_userAdmin.getUid(),Integer.parseInt("-"+moneys));
        C_News c_news=new C_News();
        c_news.setNcontext("您刚刚通过"+tmodes+"了"+moneys+"元钱");
        c_news.setDatetime(new Date());
        c_news.setType("交易记录");
        c_news.setUid(c_userAdmin.getUid());
        c_newsService.Recharge(c_news);
        session.setAttribute("userAdmin",c_userAdminService.selone(c_userAdmin.getUid()));
        return 1;
    }

    //视频评论
    @RequestMapping("VideoComment")
    @ResponseBody
    public int VideoComment(C_VideoComment c_videoComment,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_videoComment.setDatetime(new Date());
        c_videoComment.setGood(0);
        c_videoComment.setUid(c_userAdmin.getUid());
        System.out.println("c_videoComment = " + c_videoComment);
        c_videoCommentService.add(c_videoComment);
        return 1;
    }

    //视频回复评论
    @RequestMapping("VideoReplyComments")
    @ResponseBody
    public int VideoReplyComments(C_VideoReply c_videoReply,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_videoReply.setDatetime(new Date());
        c_videoReply.setUid(c_userAdmin.getUid());
        c_videoReply.setGood(0);
        c_videoReplyService.add(c_videoReply);
        return 1;
    }

    //点赞视频评论
    @RequestMapping("LikeVideoComments")
    @ResponseBody
    public int LikeVideoComments(Integer vcid,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_videoCommentService.updateGood(vcid);
        C_Comyngood c_comyngood=new C_Comyngood();
        c_comyngood.setUid(c_userAdmin.getUid());
        c_comyngood.setVcid(vcid);
        c_comyngoodService.add(c_comyngood);
        return 1;
    }

    //点赞视频评论的回复
    @RequestMapping("LikeVideoCommentsReply")
    @ResponseBody
    public int LikeVideoCommentsReply(Integer vrid,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_videoReplyService.updateGood(vrid);
        C_YncomreplyGood c_yncomreplyGood=new C_YncomreplyGood();
        c_yncomreplyGood.setUid(c_userAdmin.getUid());
        c_yncomreplyGood.setVrid(vrid);
        c_yncomreplyGoodService.add(c_yncomreplyGood);
        return 1;
    }

    //判断是否点赞过该评论
    @RequestMapping("YnVideoComments")
    @ResponseBody
    public int YnVideoComments(Integer vcid,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        C_Comyngood c_comyngood = c_comyngoodService.queryByUidVcid(c_userAdmin.getUid(), vcid);
        if(null !=c_comyngood){
            return 1;
        }
        return 0;
    }
    //判断是否点赞过该评论的回复
    @RequestMapping("YnVideoCommentsReply")
    @ResponseBody
    public int YnVideoCommentsReply(Integer vrid,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        C_YncomreplyGood c_yncomreplyGood = c_yncomreplyGoodService.queryByUidVrid(c_userAdmin.getUid(), vrid);
        if(null !=c_yncomreplyGood){
            return 1;
        }
        return 0;
    }

    //打赏
    @RequestMapping("dsvideo")
    public String dsvideo(int uid,int dscb,int sycb,int vid,HttpSession session){
        C_News c_news=new C_News();
        c_news.setType("交易记录");
        c_news.setDatetime(new Date());
        c_news.setUid(uid);
        c_news.setNcontext("您打赏消费了"+dscb+"C币,剩余"+(sycb-dscb)+"C币");
        c_newsService.Recharge(c_news);

        C_Recordaward c_recordaward=new C_Recordaward();
        c_recordaward.setVid(vid);
        c_recordaward.setDatetime(new Date());
        c_recordaward.setPrices(String.valueOf(dscb));
        c_recordaward.setUid(c_selVideoService.selviduser(vid).getUid());

        c_recordawardService.addrecordward(c_recordaward);

        c_userAdminService.updatejsCCoin(uid,dscb);
        c_userAdminService.updateCCoin(c_selVideoService.selviduser(vid).getUid(),dscb);
        session.setAttribute("userAdmin", c_userAdminService.selone(uid));
        return "redirect:/qt/selvideo?vid="+vid;
    }

    //番剧购买意向
    @RequestMapping("PurchaseIntentionofFanju")
    @ResponseBody
    public int PurchaseIntentionofFanju(C_Folkshopping c_folkshopping,HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        c_folkshopping.setDatetime(new Date());
        c_folkshopping.setUid(c_userAdmin.getUid());
        c_folkshoppingService.add(c_folkshopping);
        return 1;
    }

}
