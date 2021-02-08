package com.aaa.service;

import com.aaa.dao.C_FolkCommentDAO;
import com.aaa.dao.C_FolkReplyDAO;
import com.aaa.dao.C_YnFolkCommentDAO;
import com.aaa.dao.C_YnFolkReplyDAO;
import com.aaa.entity.C_FolkComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_FolkCommentService {

    @Resource
    C_FolkCommentDAO c_folkCommentDAO;
    @Resource
    C_FolkReplyDAO c_folkReplyDAO;
    @Resource
    C_YnFolkReplyDAO c_ynFolkReplyDAO;
    @Resource
    C_YnFolkCommentDAO c_ynFolkCommentDAO;

    public int add(C_FolkComment c_folkComment){
        return c_folkCommentDAO.insert(c_folkComment);
    }

    //根据fid查询番剧评论
    public List<Map<String,Object>> queryByfid(Integer fid){
        List<Map<String, Object>> list = c_folkCommentDAO.queryByfid(fid);
        for(Map<String, Object> map:list){
            String fcid=map.get("fcid").toString();
            List<Map<String, Object>> list2 = c_folkReplyDAO.queryByFcid(Integer.parseInt(fcid));
            for(Map<String, Object> map2 :list2){
                String frid=map2.get("frid").toString();
                List<Integer> reuids=c_ynFolkReplyDAO.queryUidsByFrid(Integer.parseInt(frid));
                map2.put("reuids",reuids);
            }
            map.put("replys",list2);
            List<Integer> uids=c_ynFolkCommentDAO.queryUidsByFcid(Integer.parseInt(fcid));
            map.put("uids",uids);
        }
        return list;
    }

    public Integer updateGood(Integer fcid){
        return c_folkCommentDAO.updateGood(fcid);
    }
}
