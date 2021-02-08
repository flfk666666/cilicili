package com.aaa.dao;

import com.aaa.entity.C_FolkReply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_FolkReplyDAO extends Mapper<C_FolkReply> {

    //根据fcid查询番剧评论的回复
    @Select("select cf.*,cu.alias,cu.Headimg,cu.Grade from c_folkreply cf inner join c_useradmin cu\n" +
            " on cf.uid=cu.uid where fcid=#{param1}")
    List<Map<String,Object>> queryByFcid(Integer fcid);

    //根据frid点赞番剧评论的回复
    @Update("update c_folkreply set good=good+1 where frid=#{param1}")
    Integer updateGood(Integer frid);
}
