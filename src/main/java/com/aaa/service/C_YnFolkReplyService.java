package com.aaa.service;

import com.aaa.dao.C_YnFolkReplyDAO;
import com.aaa.entity.C_YnFolkReply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_YnFolkReplyService {

    @Resource
    C_YnFolkReplyDAO c_ynFolkReplyDAO;

    public int add(C_YnFolkReply c_ynFolkReply){
        return c_ynFolkReplyDAO.insert(c_ynFolkReply);
    }

    public C_YnFolkReply queryByUidFrid(Integer uid,Integer frid){
        return c_ynFolkReplyDAO.queryByUidFrid(uid, frid);
    }

    public Integer queryReviewsByFid(Integer fid){
        return c_ynFolkReplyDAO.queryReviewsByFid(fid);
    }
}
