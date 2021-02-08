package com.aaa.service;

import com.aaa.dao.C_YnFolkCommentDAO;
import com.aaa.entity.C_YnFolkComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_YnFolkCommentService {
    @Resource
    C_YnFolkCommentDAO c_ynFolkCommentDAO;

    public int add(C_YnFolkComment c_ynFolkComment){
        return c_ynFolkCommentDAO.insert(c_ynFolkComment);
    }

    public C_YnFolkComment findByUidFcid(Integer uid,Integer fcid){
        return c_ynFolkCommentDAO.findByUidFcid(uid, fcid);
    }
}
