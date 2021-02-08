package com.aaa.service;

import com.aaa.dao.C_FolkReplyDAO;
import com.aaa.entity.C_FolkReply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_FolkReplyService {

    @Resource
    C_FolkReplyDAO c_folkReplyDAO;

    public int add(C_FolkReply c_folkReply){
        return c_folkReplyDAO.insert(c_folkReply);
    }
    public Integer updateGood(Integer frid){
        return c_folkReplyDAO.updateGood(frid);
    }
}
