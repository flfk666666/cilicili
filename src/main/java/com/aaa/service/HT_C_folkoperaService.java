package com.aaa.service;

import com.aaa.dao.HT_C_folkoperaDao;
import com.aaa.entity.C_Folkopera;

import com.aaa.util.Epage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HT_C_folkoperaService  {

    @Resource
    HT_C_folkoperaDao ht_c_folkoperaDao;

    public List<C_Folkopera>ht_findfolkopera(){
        return ht_c_folkoperaDao.ht_findfolkopera();
    }

    //分页查询
    public Epage<C_Folkopera> ht_findPage(Integer pagenum,Integer pageSize){
        PageHelper.startPage(pagenum,pageSize);
        PageInfo<C_Folkopera> pageInfo = new PageInfo<C_Folkopera>(ht_c_folkoperaDao.ht_findfolkopera());
        Epage<C_Folkopera> epage = new Epage<C_Folkopera>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }


    //模糊查询
    public List<Map<String,Object>> ht_findvague(String fname){
        return ht_c_folkoperaDao.ht_findvague(fname);
    }


    //查询是否上架
    public  List<Map<String,Object>> selfolksjyn(String state){
        return ht_c_folkoperaDao.selfolkysj(state);
    }
    //上架或下架番剧
    public int upfolksj(String state,int fid){
        return ht_c_folkoperaDao.upfolksj(state,fid);
    }

    public int upfolksh(String state,int fid){
        return ht_c_folkoperaDao.upfolksh(state,fid);
    }







}
