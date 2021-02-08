package com.aaa.service;

import com.aaa.dao.HT_C_FolkshoppingDAO;
import com.aaa.entity.C_Folkshopping;
import com.aaa.util.Epage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.Each;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HT_C_FolkshoppingService {
    @Resource
    HT_C_FolkshoppingDAO ht_c_folkshoppingDAO;
    public Epage<C_Folkshopping>findPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//分页开始
        PageInfo<C_Folkshopping> pageInfo = new PageInfo<C_Folkshopping>(ht_c_folkshoppingDAO.query());
          Epage<C_Folkshopping>epage=new Epage<C_Folkshopping>(pageInfo.getTotal(),pageInfo.getList());
          return epage;
    }
    public List<C_Folkshopping>findAll(){
         return ht_c_folkshoppingDAO.findAll();
    }
}
