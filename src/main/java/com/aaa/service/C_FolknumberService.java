package com.aaa.service;

import com.aaa.dao.C_FolknumberDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_FolknumberService {

    @Resource
    C_FolknumberDAO c_folknumberDAO;
}
