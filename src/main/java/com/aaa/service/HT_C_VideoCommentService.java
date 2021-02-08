package com.aaa.service;

import com.aaa.dao.HT_C_VideoCommentDAO;
import com.aaa.entity.C_Video;
import com.aaa.entity.C_VideoComment;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HT_C_VideoCommentService {
    @Resource
    HT_C_VideoCommentDAO ht_c_videoCommentDAO;
      //查询番剧评论
    public List<Map<String,Object>>VfindAll(){
        return ht_c_videoCommentDAO.VfindAll();
    }
    //删除番剧评论
    public int delete(Integer vcid){
        return ht_c_videoCommentDAO.Del(vcid);
    }
    //分页
    public Epage<C_VideoComment> findAllPage(int pagenum, int pageSize){
        PageHelper.startPage(pagenum, pageSize);//分页开始
        PageInfo<C_VideoComment> pageInfo=new PageInfo<C_VideoComment>(ht_c_videoCommentDAO.findAll());
        Epage<C_VideoComment>epage=new Epage<C_VideoComment>(pageInfo.getTotal(),pageInfo.getList());
        return epage;
    }
}
