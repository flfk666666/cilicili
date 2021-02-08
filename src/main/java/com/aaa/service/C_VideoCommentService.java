package com.aaa.service;

import com.aaa.dao.C_ComyngoodDAO;
import com.aaa.dao.C_VideoCommentDAO;
import com.aaa.dao.C_VideoReplyDAO;
import com.aaa.dao.C_YncomreplyGoodDAO;
import com.aaa.entity.C_VideoComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class C_VideoCommentService {

    @Resource
    C_VideoCommentDAO c_videoCommentDAO;
    @Resource
    C_VideoReplyDAO c_videoReplyDAO;
    @Resource
    C_ComyngoodDAO c_comyngoodDAO;
    @Resource
    C_YncomreplyGoodDAO c_yncomreplyGoodDAO;

    public int add(C_VideoComment c_videoComment){
        return c_videoCommentDAO.insert(c_videoComment);
    }
    //根据vid查询视频评论
    public List<Map<String,Object>> queryByVid(Integer vid){
        List<Map<String, Object>> list = c_videoCommentDAO.queryByVid(vid);
        for(Map<String,Object> map:list){
            String vcid=map.get("vcid").toString();
            List<Map<String, Object>> list2 = c_videoReplyDAO.query(Integer.parseInt(vcid));
            for(Map<String,Object> map2 :list2){
                String vrid=map2.get("vrid").toString();
                List<Integer> reuids = c_yncomreplyGoodDAO.queryUidsByVrid(Integer.parseInt(vrid));
                map2.put("reuids",reuids);
            }
            map.put("replys",list2);
            List<Integer> uids=c_comyngoodDAO.queryUidByVcid(Integer.parseInt(vcid));
            map.put("uids",uids);
        }
        return list;
    }

    //根据vid查询视频总评论(该视频的评论和回复)
    public Integer queryGeneralCommentByVid(Integer vid){
        return c_videoCommentDAO.queryGeneralCommentByVid(vid);
    }
    //根据vcid点赞评论
    public Integer updateGood(Integer vcid){
        return c_videoCommentDAO.updateGood(vcid);
    }
}
