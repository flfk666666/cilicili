package com.aaa.dao;

import com.aaa.entity.C_Folkopera;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface HT_C_folkoperaDao extends Mapper<C_Folkopera> {
@Select("select fid,fname,folkcover,state,company,stateupdate,workup from c_folkopera order by fid desc")
    List<C_Folkopera> ht_findfolkopera();


@Select("select fid,fname,folkcover,state,company,stateupdate,workup " +
        "from c_folkopera  where\n" +
        "fname like  concat('%',#{param3},'%') order by fid desc")
    List<Map<String,Object>> ht_findvague(String fname);

    //查询已上架/未上架番剧
    @Select("select f.*,(select max(fnumber) upnumber from c_folknumber where state='已更新' and fid=f.fid) upnumber from c_folkopera f where state=#{state}")
    List<Map<String,Object>> selfolkysj(String state);

    //上架或下架番剧
    @Update("UPDATE c_folkopera set state=#{param1} where fid=#{param2}")
    int upfolksj(String state,int fid);

    //提交番剧审核
    @Update("update c_folkopera set state=#{param1} where fid=#{param2}")
    int upfolksh(String state,int fid);



}
