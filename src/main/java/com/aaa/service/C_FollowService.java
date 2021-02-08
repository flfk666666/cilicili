package com.aaa.service;

import com.aaa.dao.C_FollowDao;
import com.aaa.entity.C_Follow;
import com.aaa.entity.C_UserAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_FollowService {
    @Resource
    C_FollowDao c_followDao;

    public C_Follow selfollowyn(int uid,int fuid){
        return c_followDao.selfollowyn(uid, fuid);
    }
    public int addfollow(C_Follow c_follow){
        return c_followDao.insert(c_follow);
    }
    public int delfollow(C_Follow c_follow){
        return c_followDao.delete(c_follow);
    }

    public List<C_UserAdmin> selwdfs(int fuid){
        return c_followDao.selwdfs(fuid);
    }

    public List<C_UserAdmin> selwdgz(int uid){
        return c_followDao.selwdgz(uid);
    }
}
