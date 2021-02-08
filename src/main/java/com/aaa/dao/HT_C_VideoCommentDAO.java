package com.aaa.dao;

import com.aaa.entity.C_VideoComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface HT_C_VideoCommentDAO {
     @Select("select cv.vcid,cv.vid,cv.context,cv.uid,cv.datetime,cv.good from c_videocomment cv inner join c_useradmin cu on cu.uid=cv.uid order by cv.vcid desc")
    List<Map<String,Object>>VfindAll();
     @Delete("delete from c_videocomment where vcid=#{vcid}")
    int Del(Integer vcid);
      @Select("select * from c_videocomment order by vcid desc")
    List<C_VideoComment>findAll();
}
