package com.aaa.service;

import com.aaa.dao.C_selVideoDao;
import com.aaa.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_selVideoService {

    @Resource
    C_selVideoDao c_selVideoDao;

    public C_Video selonevideo(int vid){
        return c_selVideoDao.selvideo(vid);
    }

    public List<C_Barrage> seldm(int vid){
        return c_selVideoDao.selalldm(vid);
    }

    public int adddm(C_Barrage c_barrage){
        return c_selVideoDao.insert(c_barrage);
    }

    public int newdmid(){
        return c_selVideoDao.selnewdmid();
    }

    public int adddmvideo(int id,int vid){
        return c_selVideoDao.adddmvideo(id,vid);
    }

    public int adduidolddm(C_BarrageHistory c_barrageHistory){
        return c_selVideoDao.adduidolddm(c_barrageHistory);
    }

    public C_UserAdmin selviduser(int vid){
        return c_selVideoDao.selviduser(vid);
    }

    public List<C_tjVideo> selxgviedo(int vid){
        return c_selVideoDao.selxgvideo(vid);
    }

}
