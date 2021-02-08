package com.aaa.dao;

import com.aaa.entity.C_YnFolkComment;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_YnFolkCommentDAO extends Mapper<C_YnFolkComment> {

    //判断用户是否点赞过番剧的评论
    @Select("select * from c_ynfolkcomment where uid=#{param1} and fcid=#{param2}")
    C_YnFolkComment findByUidFcid(Integer uid, Integer fcid);

    //查询uid通过fcid
    @Select("select uid from c_ynfolkcomment where fcid=#{param1}")
    List<Integer> queryUidsByFcid(Integer fcid);
}
