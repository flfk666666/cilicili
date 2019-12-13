package com.aaa.dao;

import com.aaa.entity.C_UserAdmin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface C_UserAdminDAO extends Mapper<C_UserAdmin> {

    //前台登录
    @Select("select * from c_useradmin where uname =#{param1} and pwd=#{param2}")
    C_UserAdmin login(String uname, String pwd);
    //根据uid查询单个用户
    @Select("select * from c_useradmin where uid=#{uid}")
    C_UserAdmin seluidone(int uid);
}
