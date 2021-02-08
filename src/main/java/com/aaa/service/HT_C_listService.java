package com.aaa.service;

import com.aaa.dao.HT_C_listDao;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_list;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HT_C_listService {

    @Resource
    HT_C_listDao ht_c_listDao;

    //显示
    public List<C_list> ht_findAll(int uid){
        return ht_c_listDao.ht_findAll(uid);
    }


    //显示全部
    public List<C_list> ht_listquery(){
        return ht_c_listDao.selectAll();
    }

    //删除
    public int htdel(Integer lid){
        return ht_c_listDao.deleteByPrimaryKey(lid);
    }

    //修改
    public int htupdate(C_list c_list){
        return ht_c_listDao.updateByPrimaryKey(c_list);
    }

    //添加
    public int htadd(C_list c_list){
        return ht_c_listDao.insert(c_list);
    }


}
