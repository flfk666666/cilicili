package com.aaa.dao;

import com.aaa.entity.C_Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_VideoDAO extends Mapper<C_Video> {
    //最热投稿,根据播放量倒叙查询某个分类的前八条视频
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            "on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            "on c.uid=ca.uid\n" +
            " where cv.vcname=#{param1} and c.state=0 order by c.PlaybackValue desc limit 0,8;")
    List<C_Video> queryByVcnamePlaybackValue(String vcname);
    //最新投稿,根据上传时间倒叙查询某个分类的前八条视频
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            "            on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            "            on c.uid=ca.uid \n" +
            "             where cv.vcname=#{param1} and c.state=0 order by c.vtime desc limit 0,10")
    List<C_Video> queryByVcnameVtime(String vcname);

    //热门，根据点赞量查询某个分类的前八条数据
    @Select("select c.`*`,ca.alias from c_video c inner join c_videoclassification cv \n" +
            " on c.vfid=cv.vfid inner join c_useradmin ca \n" +
            " on c.uid=ca.uid \n" +
            " where cv.vcname=#{param1} and c.state=0 order by c.Fabulous desc limit 0,8")
    List<C_Video> queryByVcnameFabulous(String vcname);

    //查询是否点赞
    @Select("select count(*) from C_YNgood where uid=#{param1} and vid=#{param2}")
    int seldzyn(int uid,int vid);
    //点赞
    @Insert("insert into c_yngood values(#{param1},#{param2})")
    int insdz(int uid,int vid);
    //增加播放量
    @Update("update c_video set fabulous=fabulous+1 where vid=#{vid}")
    int addbfl(int vid);


    //根据用户查询视频
    @Select("select * from c_video where uid=#{param1} and state=0 order by vtime desc")
    List<C_Video> queryByUid(Integer uid);

    //根据uid和vid删除视频(把state改为1)
    @Update("update c_video set state=1 where uid=#{param1} and vid =#{param2}")
    int updateVideoState(Integer uid,Integer vid);

    //根据uid查询视频总播放量
    @Select("select sum(PlaybackValue) from c_video where uid=#{param1}")
    Integer queryPlaybackValueByUid(Integer uid);




    //根据点赞量倒叙查询前6条
    @Select("select c.*,cu.uname,cu.alias from c_video c inner join c_useradmin cu\n" +
            "on c.uid=cu.uid order by c.Fabulous desc limit 0,6")
    List<Map<String,Object>> queryByFabulous();

    //查询分类为广告，按点赞数倒叙前4条
    @Select("select c.*,cu.uname,cu.alias from c_video c inner join c_useradmin cu\n" +
            "on c.uid=cu.uid where vfid=5 order by Fabulous desc\n" +
            " limit 0,4")
    List<Map<String,Object>> queryByFabulousAndVfid();



    //    模糊查询
    @Select("select * from c_video c_v left join c_useradmin c_u\n" +
            "on c_v.uid=c_u.uid where c_v.state=0 and c_v.vname like concat('%',#{param1},'%')\n")
    List<Map<String,Object>>  qt_queryvaguevaname(String vname);


    //查询全部
    @Select("select c_vi.*,c_user.uname from c_video c_vi inner join c_useradmin c_user\n" +
            "\ton c_vi.uid=c_user.uid where c_vi.state=0")
    public List<Map<String,Object>>  qt_findC_Video();

    //查询每个视频分类的数量
    @Select("select max(if(t.vcname='广告',t.num,0)) '广告',\n" +
            "max(if(t.vcname='科技',t.num,0)) '科技',\n" +
            "max(if(t.vcname='生活',t.num,0)) '生活',\n" +
            "max(if(t.vcname='音乐',t.num,0)) '音乐',\n" +
            "max(if(t.vcname='游戏',t.num,0)) '游戏',\n" +
            "max(if(t.vcname='娱乐',t.num,0)) '娱乐',\n" +
            "max(if(t.vcname='番剧',t.num,0)) '番剧' from (\n" +
            "select cc.vcname,count(*) num from c_video c inner join c_videoclassification cc on c.vfid=cc.vfid\n" +
            "group by cc.vcname union \n" +
            "select '番剧' as 'vcname',count(*) num from c_folkopera where state='已上架'\n" +
            ") t")
    Map<String,Object> queryCateNum();


    //查询视频播放量前五
    @Select("select vname,PlaybackValue from c_video order by PlaybackValue desc limit 0,5")
    List<Map<String,Object>> queryTop5();

}
