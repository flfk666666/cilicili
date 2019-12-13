package com.aaa.service;

import com.aaa.dao.C_UserAdminDAO;
import com.aaa.entity.C_UserAdmin;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class C_UserAdminService {

    @Resource
    C_UserAdminDAO c_userAdminDAO;

    public C_UserAdmin login(String uname,String pwd){
        return c_userAdminDAO.login(uname,pwd);
    }

    public int register(C_UserAdmin c_userAdmin){
        return c_userAdminDAO.insert(c_userAdmin);
    }

    public C_UserAdmin selone(int uid){
        return c_userAdminDAO.seluidone(uid);
    }

    public int updateUserInfo(C_UserAdmin c_userAdmin){
        return c_userAdminDAO.updateByPrimaryKey(c_userAdmin);
    }
}
