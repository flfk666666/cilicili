package com.aaa.service;

import com.aaa.dao.HT_C_ScoringDAO;
import com.aaa.entity.C_FolkComment;
import com.aaa.entity.C_Scoring;
import com.aaa.entity.C_Video;
import com.aaa.entity.HT_C_Scoring;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Ht_C_ScoringService {
    @Resource
    HT_C_ScoringDAO ht_c_scoringDAO;
    public List<Map<String,Object>>findAll(){
        return ht_c_scoringDAO.findAll();
    }
    public int delete(Integer sid){
        return ht_c_scoringDAO.Del(sid);
    }
    //分页
    public Epage<C_Scoring> findAllPage(int pagenum, int pageSize){
        PageHelper.startPage(pagenum, pageSize);//分页开始
        PageInfo<C_Scoring> pageInfo=new PageInfo<C_Scoring>(ht_c_scoringDAO.findPage());
        Epage<C_Scoring>epage=new Epage<C_Scoring>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }
}
