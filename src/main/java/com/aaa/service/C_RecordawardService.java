package com.aaa.service;

import com.aaa.dao.C_RecordawardDAO;
import com.aaa.entity.C_Recordaward;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_RecordawardService {

    @Resource
    C_RecordawardDAO c_recordawardDAO;
    public List<Map<String,Object>> queryByUid(Integer uid){
        return c_recordawardDAO.queryByUid(uid);
    }

    public Integer queryTotalMoneyByUid(Integer uid){
        return c_recordawardDAO.queryTotalMoneyByUid(uid);
    }

    public Integer selrecordyn(int vid,int uid){
        return c_recordawardDAO.selrecordyn(vid, uid);
    };

    public Integer selsumvideo(int vid){
        return c_recordawardDAO.selsumvideo(vid);
    }

    public Integer addrecordward(C_Recordaward c_recordaward){
        return c_recordawardDAO.insert(c_recordaward);
    };



}
