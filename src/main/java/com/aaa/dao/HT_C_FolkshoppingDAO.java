package com.aaa.dao;

import com.aaa.entity.C_Folkshopping;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HT_C_FolkshoppingDAO extends Mapper<C_Folkshopping> {
    @Select("select f.fsid,f.folkname,f.context,f.datetime,u.uid from c_folkshopping f inner join c_useradmin u on u.uid=f.uid")
    List<C_Folkshopping> query();

//    @Select("select f.fsid,f.folkname,f.context,f.datetime,u.uid from c_folkshopping f inner join c_useradmin u on u.uid=f.uid")
    @Select("select * from c_folkshopping order by fsid desc")
    List<C_Folkshopping>findAll();

}
