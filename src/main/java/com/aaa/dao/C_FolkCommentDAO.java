package com.aaa.dao;

import com.aaa.entity.C_FolkComment;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_FolkCommentDAO extends Mapper<C_FolkComment> {

    //根据fid查询番剧评论
    @Select("select cf.*,cu.alias,cu.Headimg,cu.Grade from c_folkcomment cf inner join c_useradmin cu\n" +
            " on cf.uid=cu.uid where cf.fid=#{param1}")
    List<Map<String,Object>> queryByfid(Integer fid);

    //根据fcid点赞评论
    @Update("update c_folkcomment set good=good+1 where fcid=#{param1}")
    Integer updateGood(Integer fcid);
}
