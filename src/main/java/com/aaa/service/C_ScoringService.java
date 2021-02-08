package com.aaa.service;

import com.aaa.dao.C_ScoringDao;
import com.aaa.entity.C_Scoring;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_ScoringService {

    @Resource
    C_ScoringDao c_scoringDao;

    public int addscoring(C_Scoring c_scoring){
        return c_scoringDao.adddp(c_scoring);
    }

    public C_Scoring seldpyn(int fid,int uid){
        return c_scoringDao.seldpyn(fid, uid);
    }

    public List<C_Scoring> selScoring(int fid){
        return c_scoringDao.selScoring(fid);
    }

    public List<Map<String,Object>> selfjzxScoring(int fid){
        return c_scoringDao.selfjzxScoring(fid);
    }


}
