package com.aaa.service;

import com.aaa.dao.C_VideoClassificationDAO;
import com.aaa.entity.C_VideoClassification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_VideoClassificationService {

    @Resource
    C_VideoClassificationDAO c_videoClassificationDAO;

    public List<C_VideoClassification> query(){
        return c_videoClassificationDAO.query();
    }
}
