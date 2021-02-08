package com.aaa.dao;

import com.aaa.entity.C_YnFolkReply;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_YnFolkReplyDAO extends Mapper<C_YnFolkReply> {

    //判断是否点赞过番剧评论的回复
    @Select("select * from c_ynfolkreply where uid=#{param1} and frid =#{param2}")
    C_YnFolkReply queryByUidFrid(Integer uid, Integer frid);

    //查询uid通过frid
    @Select("select uid from c_ynfolkreply where frid=#{param1}")
    List<Integer> queryUidsByFrid(Integer frid);

    //查询某个番剧的评论数
    @Select("select count(*)+sum(replyCounts) from(\n" +
            " select cf.*,(select count(*) from c_folkreply cr\n" +
            " where cr.fcid=cf.fcid) replyCounts from c_folkcomment cf  where fid=#{param1}\n" +
            " ) t")
    Integer queryReviewsByFid(Integer fid);
}
