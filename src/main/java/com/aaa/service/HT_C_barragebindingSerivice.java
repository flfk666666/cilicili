package com.aaa.service;

import com.aaa.dao.HT_C_barragebindingDao;
import com.aaa.entity.C_Barrage;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HT_C_barragebindingSerivice {

    @Resource
    HT_C_barragebindingDao ht_c_barragebindingDao;


    public int ht_binddelete(Integer id){
        return ht_c_barragebindingDao.deleteByPrimaryKey(id);
    }




}
