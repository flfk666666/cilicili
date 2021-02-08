package com.aaa.service;

import com.aaa.dao.HT_C_FolkCommentDAO;
import com.aaa.entity.C_FolkComment;
import com.aaa.entity.C_VideoComment;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HT_C__FolkCommentService {
    @Resource
    HT_C_FolkCommentDAO ht_c_folkCommentDAO;
    //查询视频评论
    public List<Map<String,Object>>FfindAll(){
        return ht_c_folkCommentDAO.FfindAll();
    }
   //删除视频评论
    public int deletea(Integer fcid){
        return ht_c_folkCommentDAO.delete(fcid);
    }
    //分页
    public Epage<C_FolkComment> findAllPage(int pagenum, int pageSize){
        PageHelper.startPage(pagenum, pageSize);//分页开始
        PageInfo<C_FolkComment> pageInfo=new PageInfo<C_FolkComment>(ht_c_folkCommentDAO.findAll());
        Epage<C_FolkComment>epage=new Epage<C_FolkComment>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }
}
