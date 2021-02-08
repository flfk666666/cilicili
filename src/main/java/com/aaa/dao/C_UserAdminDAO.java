package com.aaa.dao;

import com.aaa.entity.C_Advertisement;
import com.aaa.entity.C_UserAdmin;
import com.aaa.entity.C_Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_UserAdminDAO extends Mapper<C_UserAdmin> {

    //前台登录
    @Select("select * from c_useradmin where uname =#{param1} and pwd=#{param2}")
    C_UserAdmin login(String uname, String pwd);
    //根据uid查询单个用户
    @Select("select * from c_useradmin where uid=#{uid}")
    C_UserAdmin seluidone(int uid);

    //充值，根据uid为用户增加C币
    @Update("update c_useradmin set CCoin=CCoin+#{param2} where uid=#{param1}")
    int updateCCoin(Integer uid,Integer Num);

    //充值，根据uid为用户减少C币
    @Update("update c_useradmin set CCoin=CCoin-#{param2} where uid=#{param1}")
    int updatejsCCoin(Integer uid,Integer Num);

    //修改空间宣言
    @Update("update c_useradmin set Spacedeclaration=#{param2} where uid=#{param1}")
    int updateSpacedeclaration(Integer uid,String cont);
    //修改个性签名
    @Update("update c_useradmin set Personalized=#{param2} where uid=#{param1}")
    int updatePersonalized(Integer uid,String Personalized);

    //判断视频是否播放过
    @Select("SELECT count(*) from C_YNplayvalue where ip=#{param1} and vid=#{param2}")
    int selvideoip(String ip,int vid);

    //判断番剧是否播放过
    @Select("SELECT count(*) from C_YNplayvalueFolk where ip=#{param1} and fid=#{param2}")
    int selfolkip(String ip,int fid);

    //放入ip视频播放表
    @Insert("insert into C_YNplayvalue values(#{param1},#{param2})")
    int addipvideo(String ip,int vid);

    //放入ip番剧播放表
    @Insert("insert into C_YNplayvalueFolk values(#{param1},#{param2})")
    int addipfolk(String ip,int fid);
    //增加视频播放量
    @Update("UPDATE c_video set playbackValue=playbackValue+1 where vid=#{vid}")
    int upvideopaly(int vid);

    //增加番剧播放量
    @Update("UPDATE c_folkopera set playbackValue=playbackValue+1 where fid=#{fid}")
    int upfolkpaly(int fid);


    //模糊查询
    @Select("select * from c_useradmin\n" +
            "where state='正常' and alias like concat('%',#{param1},'%')")
    List<Map<String,Object>> qt_vagueuname(String uname);

    //查询全部
    @Select("select * from c_useradmin where state='正常'")
    List<Map<String,Object>> qt_useradminfindAll();

    //查询用户置顶视频
    @Select("select * from c_video where uid=#{uid} and Z_index=1")
    C_Video seluserzd(int uid);

    //修改当前用户所有置顶
    @Update("UPDATE c_video set z_index=0 where uid=#{uid}")
    public int upallvideo(int uid);
    //设置置顶视频/取消视频
    @Update("UPDATE c_video set z_index=#{param1} where vid=#{param2}")
    public int upzdvideo(int z_index,int vid);

    //查询自己点赞的视频
    @Select("select * from c_video where vid in (select vid from c_yngood where uid=#{uid})")
    public List<C_Video> medzvideo(int uid);


    //查询广告位
    @Select("select * from c_advertisement where type=#{type}")
    public List<C_Advertisement> selament(String type);


    //查询用户数据
    @Select("with a\n" +
            "as(\n" +
            "#查看关注我的所有粉丝\n" +
            " select fuid,count(uid) a from c_follow\n" +
            "where fuid=#{param1}\n" +
            "),\n" +
            "b as\n" +
            "(\n" +
            "#查询播放量\n" +
            " select uid,sum(PlaybackValue) b  from c_video\n" +
            " where uid=#{param1}\n" +
            "),\n" +
            "c as\n" +
            "(\n" +
            "##弹幕数\n" +
            " select cvi.uid,count(cba.id) c from c_barrage\n" +
            "cba left join c_barragebinding cbar\n" +
            "on cba.id=cbar.id\n" +
            "left join c_video cvi on cbar.vid=cvi.vid\n" +
            "where cvi.uid=#{param1}\n" +
            "),\n" +
            "d as\n" +
            "(\n" +
            "#查询点赞数\n" +
            " select cvi.uid,sum(cvi.Fabulous) d From c_video cvi\n" +
            "where cvi.uid=#{param1}\n" +
            "),\n" +
            "f as\n" +
            "(\n" +
            "#提现总金额:\n" +
            " select uid,sum(money) f from c_creatoramount where uid=#{param1}\n" +
            ")\n" +
            "select cu.uid,a.a,b.b,c.c,d.d,f.f from c_useradmin cu\n" +
            "left join a on cu.uid=a.fuid\n" +
            "left join b on cu.uid=b.uid\n" +
            "left join c on cu.uid=c.uid\n" +
            "left join d on cu.uid=d.uid\n" +
            "left join f on cu.uid=f.uid\n" +
            "where  cu.uid=#{param1}")
    Map<String,Object> queryDataByUid(Integer uid);

    //查询用户评论数量
    @Select("select \n" +
            "(select count(*) from c_videocomment where uid=#{param1} )\n" +
            "+(select count(*) from c_videoreply where uid=#{param1}) from dual;")
    Integer queryReviewCountByUid(Integer uid);


}
