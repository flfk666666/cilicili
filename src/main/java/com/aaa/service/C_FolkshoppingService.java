package com.aaa.service;

import com.aaa.dao.C_FolkshoppingDAO;
import com.aaa.entity.C_Folkshopping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_FolkshoppingService {

    @Resource
    C_FolkshoppingDAO c_folkshoppingDAO;

    public int add(C_Folkshopping c_folkshopping){
        return c_folkshoppingDAO.insert(c_folkshopping);
    }
}
