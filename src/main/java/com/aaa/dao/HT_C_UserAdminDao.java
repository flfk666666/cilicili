package com.aaa.dao;

import com.aaa.entity.C_UserAdmin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HT_C_UserAdminDao extends Mapper<C_UserAdmin> {


    //根据用户输入用户名到数据库进行查询
    @Select("select * from c_UserAdmin where uname=#{param1}")
    C_UserAdmin  HTfindByName(String uname);

    //获取当前用户的角色
    @Select(" select identity from c_userAdmin where uname =#{param1}")
    List<String> HTfindidentity(String uname);

    //根据角色获取当前的权限
    @Select("select cl.lname from c_UserAdmin cu join c_list cl on cu.identity=cl.ljoin where uname=#{param1}")
    List<String> HTfindbyJurisdiction(String identity);

    //用户管理
//    @Select("select uid,uname,pwd,identity,state from c_userAdmin where state='正常'")
//    List<C_UserAdmin> Ht_findstate(String state);

    //查询正常的用户
    @Select("select uid,uname,pwd,identity,state from c_userAdmin where state='正常'")
    List<C_UserAdmin> HT_findBystate(String state);

    //查询已经禁用的用户
    @Select("select uid,uname,pwd,identity,state from c_userAdmin where state='禁用'")
    List<C_UserAdmin> HT_findNOState(String state);


    //修改状态
    @Update("update c_useradmin set state=#{param1}  where uid=#{param2}")
    int update(String state, Integer uid);



    


}

