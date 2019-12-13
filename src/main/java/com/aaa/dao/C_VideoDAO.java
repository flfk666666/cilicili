package com.aaa.dao;

import com.aaa.entity.C_Video;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_VideoDAO extends Mapper<C_Video> {
    //最热投稿,根据播放量倒叙查询某个分类的前八条视频
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            "on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            "on c.uid=ca.uid\n" +
            " where cv.vcname=#{param1} order by c.PlaybackValue desc limit 0,8;")
    List<C_Video> queryByVcnamePlaybackValue(String vcname);
    //最新投稿,根据上传时间倒叙查询某个分类的前八条视频
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            "            on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            "            on c.uid=ca.uid \n" +
            "             where cv.vcname=#{param1} order by c.vtime desc limit 0,8")
    List<C_Video> queryByVcnameVtime(String vcname);

    //热门，根据点赞量查询某个分类的前八条数据
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            " on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            " on c.uid=ca.uid \n" +
            " where cv.vcname=#{param1} order by c.Fabulous desc limit 0,8")
    List<C_Video> queryByVcnameFabulous(String vcname);






}
