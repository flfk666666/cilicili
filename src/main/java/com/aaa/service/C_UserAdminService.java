package com.aaa.service;

import com.aaa.dao.C_UserAdminDAO;
import com.aaa.entity.C_Advertisement;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_Video;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_UserAdminService {

    @Resource
    C_UserAdminDAO c_userAdminDAO;

    public C_UserAdmin login(String uname,String pwd){
        return c_userAdminDAO.login(uname,pwd);
    }

    public int register(C_UserAdmin c_userAdmin){
        return c_userAdminDAO.insert(c_userAdmin);
    }

    public C_UserAdmin selone(int uid){
        return c_userAdminDAO.seluidone(uid);
    }

    public int updateUserInfo(C_UserAdmin c_userAdmin){
        return c_userAdminDAO.updateByPrimaryKey(c_userAdmin);
    }

    //充值，根据uid为用户增加C币
    public int updateCCoin(Integer uid,Integer Num){
        return c_userAdminDAO.updateCCoin(uid,Num);
    }
    //充值，根据uid为用户增加C币
    public int updatejsCCoin(Integer uid,Integer Num){
        return c_userAdminDAO.updatejsCCoin(uid,Num);
    }



    //修改空间宣言
    public int updateSpacedeclaration(Integer uid,String cont){
        return c_userAdminDAO.updateSpacedeclaration(uid,cont);
    }
    //修改个性签名
    public int updatePersonalized(Integer uid,String Personalized){
        return c_userAdminDAO.updatePersonalized(uid,Personalized);
    }

    public int selvideoip(String ip,int vid){
        return c_userAdminDAO.selvideoip(ip, vid);
    }
    public int selfolkip(String ip,int fid){
        return c_userAdminDAO.selfolkip(ip, fid);
    }

    public int upvideopaly(int vid){
        return c_userAdminDAO.upvideopaly(vid);
    }

    public int upfolkpaly(int fid){
        return c_userAdminDAO.upfolkpaly(fid);
    }

    public int addipvideo(String ip,int vid){
        return c_userAdminDAO.addipvideo(ip, vid);
    }

    public int addipfolk(String ip,int fid){
        return c_userAdminDAO.addipfolk(ip, fid);
    }



    //模糊查询
    public List<Map<String,Object>> qt_vagueuname(String uname){
        return c_userAdminDAO.qt_vagueuname(uname);
    }

    //查询全部
    public List<Map<String,Object>> qt_useradminfindAll(){
        return c_userAdminDAO.qt_useradminfindAll();
    }

    //查询用户置顶
    public C_Video seluserzd(int uid){
        return c_userAdminDAO.seluserzd(uid);
    }

    //修改全部置顶
    public int upallvideo(int uid){
        return c_userAdminDAO.upallvideo(uid);
    }

    //置顶/取消置顶
    public int upzdvideo(int z_index,int vid){
        return c_userAdminDAO.upzdvideo(z_index,vid);
    }

    public List<C_Video> medzvideo(int uid){
        return c_userAdminDAO.medzvideo(uid);
    }

    //查询广告位
    public List<C_Advertisement> selament(String type){
        return c_userAdminDAO.selament(type);
    };

    //查询用户数据
    public Map<String,Object> queryDataByUid(Integer uid){
        return c_userAdminDAO.queryDataByUid(uid);
    }
    //查询用户评论数量
    public Integer queryReviewCountByUid(Integer uid){
        return c_userAdminDAO.queryReviewCountByUid(uid);
    }

}
