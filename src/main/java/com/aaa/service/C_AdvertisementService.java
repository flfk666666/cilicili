package com.aaa.service;

import com.aaa.dao.C_AdvertisementDao;
import com.aaa.entity.C_Advertisement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_AdvertisementService {

    @Resource
    C_AdvertisementDao c_advertisementDao;

    public List<C_Advertisement> seladvert(){
        return c_advertisementDao.seladvert();
    }

    public int upadvert(C_Advertisement c_advertisement){
        return c_advertisementDao.upadvert(c_advertisement);
    }

}
