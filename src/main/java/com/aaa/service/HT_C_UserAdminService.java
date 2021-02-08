package com.aaa.service;

import com.aaa.dao.HT_C_UserAdminDao;
import com.aaa.entity.C_UserAdmin;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HT_C_UserAdminService {

    @Resource
    HT_C_UserAdminDao ht_c_userAdminDao;

    //登录
    public C_UserAdmin findHTfindByName(String uname){
        return ht_c_userAdminDao.HTfindByName(uname);
    }


    //根据当前用户获取角色
    public List<String> HTfindidentity(String uname){
        return ht_c_userAdminDao.HTfindidentity(uname);
    }

    //根据当前角色名称获取相应的权限
    public List<String> HTfindbyJurisdiction(String identity){
        return ht_c_userAdminDao.HTfindbyJurisdiction(identity);
    }

//    //查询状态
//    public Epage<C_UserAdmin> ht_findbystat(Integer pageNum,Integer pageSize,String state){
//        //分页 一页显示几条
//        PageHelper.startPage(pageNum,pageSize);
//        PageInfo<C_UserAdmin> pageInfo = new PageInfo<C_UserAdmin>(ht_c_userAdminDao.Ht_findstate(state));
//        Epage<C_UserAdmin> epage = new Epage<C_UserAdmin>(pageInfo.getTotal(),pageInfo.getList());
//        return epage;
//    }
//

    //查询状态是正常的
    public List<C_UserAdmin> HT_findByState(String state){
        return ht_c_userAdminDao.HT_findBystate(state);
    }

    //查询状态是禁用的
    public List<C_UserAdmin> ht_findNOState(String state){
        return ht_c_userAdminDao.HT_findNOState(state);
    }

    //修改状态
//    public int update(C_UserAdmin c_userAdmin){
//        return ht_c_userAdminDao.updateByPrimaryKey(c_userAdmin);
//    }


    public int updatestate(String state,Integer uid){
        return ht_c_userAdminDao.update(state, uid);
    }



}
