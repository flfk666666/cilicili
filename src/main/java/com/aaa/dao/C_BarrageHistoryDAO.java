package com.aaa.dao;

import com.aaa.entity.C_BarrageHistory;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_BarrageHistoryDAO extends Mapper<C_BarrageHistory> {
    //根据uid查询弹幕历史
    @Select("select c.`*`,ch.uid,ch.vtime,cb.vid,cv.vname from c_barrage c inner join c_barragehistory ch\n" +
            "on c.id=ch.id inner join c_barragebinding cb on cb.id=c.id \n" +
            "inner join c_video cv on cv.vid=cb.vid\n" +
            " where ch.uid=#{param1} order by ch.vtime desc")
    List<Map<String,Object>> queryByUid(Integer uid);
}
