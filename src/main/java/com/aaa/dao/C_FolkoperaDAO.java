package com.aaa.dao;

import com.aaa.entity.C_Folkopera;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_FolkoperaDAO extends Mapper<C_Folkopera> {

    //查询最新番剧,根据fid倒叙，显示9条
    @Select("select * from c_folkopera where state='已上架' order by fid desc limit 0,9")
    List<C_Folkopera> findAll();
    //查询每周几更新的番剧,根据fid倒叙，显示9条
    @Select("select * from c_folkopera where workup like concat('%',#{param1},'%') and state='已上架'  order by fid desc limit 0,9")
    List<C_Folkopera> findByWorkup(String workup);
    //根据点赞数查询番剧前8条
    @Select("select * from c_folkopera where state='已上架' order by Fabulous desc limit 0,8")
    List<C_Folkopera> queryByFabulous();
    //根据播放量查询最热番剧，显示前8条
    @Select("select * from c_folkopera where state='已上架' order by PlaybackValue desc limit 0,8")
    List<C_Folkopera> queryByPlaybackValue();
    //根据fid查询最新番剧，显示前8条
    @Select("select * from c_folkopera where state='已上架' order by fid desc limit 0,8")
    List<C_Folkopera> queryByFid();

    //按照热门查询所有番剧
    @Select("select * from c_folkopera where state='已上架' ORDER BY playbackvalue desc")
    List<C_Folkopera> selpalayallfolk();

    //按照最新查询所有番剧
    @Select("select * from c_folkopera where state='已上架' ORDER BY fid desc")
    List<C_Folkopera> selnewallfolk();


    //模糊查询

    @Select("select * from c_folkopera c_f left join c_useradmin c_u\n" +
            "on c_f.uid=c_u.uid where c_f.state='已上架' and c_f.fname \n" +
            "like concat('%',#{param1},'%')")
    List<Map<String,Object>> qtfindvaguefname(String fname);


    //查询全部
    @Select("select c_folk.*,c_user.uname from c_folkopera c_folk inner join c_useradmin c_user\n" +
            "            on c_folk.uid=c_user.uid where c_folk.state='已上架' ")
    public List<Map<String,Object>> qt_findfolkopera();

    //查询番剧库未上架的番剧
    @Select("select * from c_folkopera where state !='已上架'")
    List<Map<String,Object>> queryNotonshelves();

    //查询评分
    @Select("SELECT avg(fraction)*2 favg from c_scoring where fid=#{fid}")
    int selavgpf(int fid);

    //统计追番数
    @Select("select count(*) from C_Subscribe where fid=#{fid}")
    int selzfcount(int fid);

    //查询番剧播放量前五
    @Select("select * from c_folkopera order by PlaybackValue desc limit 0,5;")
    List<Map<String,Object>> query5ByPlaybackValue();

}
