package com.aaa.service;

import com.aaa.dao.C_VideoReplyDAO;
import com.aaa.entity.C_VideoReply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_VideoReplyService {

    @Resource
    C_VideoReplyDAO c_videoReplyDAO;

    public int add(C_VideoReply c_videoReply){
        return c_videoReplyDAO.insert(c_videoReply);
    }

    //根据vcid查询某条评论的回复
    public List<Map<String,Object>> query(Integer vcid){
        return c_videoReplyDAO.query(vcid);
    }

    //根据vrid点赞评论的回复
    public Integer updateGood(Integer vrid){
        return c_videoReplyDAO.updateGood(vrid);
    }
}
