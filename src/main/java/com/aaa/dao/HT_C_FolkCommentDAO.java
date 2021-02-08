package com.aaa.dao;

import com.aaa.entity.C_FolkComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface HT_C_FolkCommentDAO {
    @Select("select cf.fcid,cf.fid,cf.context,cf.datetime,cf.uid,cf.good from c_folkcomment cf inner join c_useradmin cu on cu.uid=cf.uid")
    List<Map<String,Object>>FfindAll();
    @Delete("delete from c_folkcomment where fcid=#{fcid}")
    int delete(Integer fcid);
    @Select("select * from c_folkcomment order by datetime desc")
    List<C_FolkComment>findAll();
}
