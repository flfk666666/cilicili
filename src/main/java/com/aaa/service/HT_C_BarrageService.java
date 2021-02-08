package com.aaa.service;

import com.aaa.dao.HT_C_BarrageDao;
import com.aaa.entity.C_Barrage;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HT_C_BarrageService {
    @Resource
    HT_C_BarrageDao ht_c_barrageDao;



    //查询弹幕管理‘
    public List<Map<String,Object>> ht_findbarrage(){
        return ht_c_barrageDao.ht_findbarrage();
    }

    //删除弹幕
    public int ht_barrageDel(Integer id){
        return ht_c_barrageDao.deleteByPrimaryKey(id);
    }



}
