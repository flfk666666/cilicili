package com.aaa.service;


import com.aaa.dao.C_selFolkDao;
import com.aaa.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_selFolkService {

    @Resource
    C_selFolkDao c_selFolkDao;

    public C_Folkopera selfolk(int fid){
        return c_selFolkDao.selfolk(fid);
    }

    public List<C_Folknumber> selfolknumber(int fid){
        return c_selFolkDao.selfolknumber(fid);
    }

    public C_Folknumber selfonenumber(int fid,int fnumber){
        return c_selFolkDao.selfonenumber(fid,fnumber);
    }

    public  List<C_Barrage> selfolkdm(int fid,int fnumber){
        return c_selFolkDao.selfolkdm(fid, fnumber);
    }

    public int adddmfolk(C_Folkbinding c_folkbinding){
        return c_selFolkDao.adddmfolk(c_folkbinding);
    }

    public List<Map<String,Object>> selxgfolk(Integer fid){
        return c_selFolkDao.selxgfolk(fid);
    };

    public int zffolk(C_Subscribe c_subscribe){
      return c_selFolkDao.zffolk(c_subscribe);
    };

    public C_Subscribe selfjyn(int uid,int fid){
        return c_selFolkDao.selzfyn(uid, fid);
    }

    public int delzffolk(int fid,int uid){
        return c_selFolkDao.delzffolk(fid, uid);
    }

    public int folkdmcount(int fid){
        return c_selFolkDao.folkdmcount(fid);
    }
}
