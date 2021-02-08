package com.aaa.dao;

import com.aaa.entity.C_Follow;
import com.aaa.entity.C_UserAdmin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_FollowDao extends Mapper<C_Follow> {

    //查询是否已关注
    @Select("select * from c_follow where uid=#{param1} and fuid=#{param2}")
    C_Follow selfollowyn(int uid,int fuid);

    //查询我的粉丝
    @Select("select * from c_useradmin where uid in (select uid from C_follow where fuid=#{fuid})")
    List<C_UserAdmin> selwdfs(int fuid);
    //查询我的关注
    @Select("select * from c_useradmin where uid in (select fuid from c_follow where uid=#{uid})")
    List<C_UserAdmin> selwdgz(int uid);



}
