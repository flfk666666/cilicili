package com.aaa.service;

import com.aaa.dao.HT_C_VideoDAO;
import com.aaa.entity.C_Video;

import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.Each;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HT_C_VideoService {
    @Resource
    HT_C_VideoDAO ht_c_videoDAO;
    //查询全部
    public List<C_Video>findAll(){
        return ht_c_videoDAO.findAll();
    }
    //修改状态
    public int doUpdate(C_Video c_video){
        return ht_c_videoDAO.doUpdate(c_video);
    }
    //分页
    public Epage<C_Video>findAllPage(int pagenum,int pageSize){
        PageHelper.startPage(pagenum, pageSize);//分页开始
        PageInfo<C_Video>pageInfo=new PageInfo<C_Video>(ht_c_videoDAO.findAll());
        Epage<C_Video>epage=new Epage<C_Video>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }
    public int update(C_Video c_video){
        return ht_c_videoDAO.doUpdate(c_video);
    }
}
