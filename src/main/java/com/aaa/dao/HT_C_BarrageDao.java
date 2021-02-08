package com.aaa.dao;

import com.aaa.entity.C_Barrage;
import com.aaa.util.Epage;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface HT_C_BarrageDao extends Mapper<C_Barrage> {


    @Select("select b.id,b.text,v.vname,u.uname from \n" +
            "c_barrage b,c_barragebinding bb,c_barragehistory\n" +
            "bh,c_video v,c_useradmin u where b.id=bb.id and\n" +
            "b.id=bh.id and bb.vid=v.vid and bh.uid=u.uid \n" +
            "order by bh.vtime desc")
    List<Map<String,Object>> ht_findbarrage();



}
