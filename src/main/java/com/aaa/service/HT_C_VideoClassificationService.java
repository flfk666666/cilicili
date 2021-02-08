package com.aaa.service;

import com.aaa.dao.HT_C_VideoclassificationDAO;
import com.aaa.entity.C_Video;
import com.aaa.entity.C_VideoClassification;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HT_C_VideoClassificationService {
    @Resource
    HT_C_VideoclassificationDAO ht_c_videoclassificationDAO;
    //查询全部
    public List<C_VideoClassification>findAll(){
        return ht_c_videoclassificationDAO.query();
    }
    //删除
    public int Delete(Integer vfid){
        return ht_c_videoclassificationDAO.Del(vfid);
    }
    //分页
    public Epage<C_VideoClassification> findAllPage(int pagenum, int pageSize){
        PageHelper.startPage(pagenum, pageSize);//分页开始
        PageInfo<C_VideoClassification> pageInfo=new PageInfo<C_VideoClassification>(ht_c_videoclassificationDAO.query());
        Epage<C_VideoClassification>epage=new Epage<C_VideoClassification>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }
}
