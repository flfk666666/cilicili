package com.aaa.service;

import com.aaa.dao.C_CollectionVideoDAO;
import com.aaa.entity.C_CollectionVideo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_CollectionVideoService {

    @Resource
    C_CollectionVideoDAO c_collectionVideoDAO;


    public C_CollectionVideo selcoll(int vid,int uid){
        return c_collectionVideoDAO.selcoll(vid, uid);
    }

    public List<C_CollectionVideo> selcollvideo(int uid){
        return c_collectionVideoDAO.selcollvideo(uid);
    }

    public List<C_CollectionVideo> seltrcollvideo(int uid){
        return c_collectionVideoDAO.seltrcollvideo(uid);
    }




    public int addcollvideo(C_CollectionVideo c_collectionVideo){
        return c_collectionVideoDAO.insert(c_collectionVideo);
    }

    public void delcollvideo(int vid,int uid){
         c_collectionVideoDAO.delsc(vid,uid);
    }

    public List<C_CollectionVideo> seltype(int uid,String type){
        return c_collectionVideoDAO.seltype(uid, type);
    }

    public int upcolltype(int type,int uid,int vid){
        return c_collectionVideoDAO.upcolltype(type, uid, vid);
    }

    public int upcolltypename(String type,String cvid){
        return c_collectionVideoDAO.upcolltypename(type, cvid);
    }
}
