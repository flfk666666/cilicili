package com.aaa.shiro;

import com.aaa.entity.C_UserAdmin;
import com.aaa.service.HT_C_UserAdminService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    HT_C_UserAdminService ht_c_userAdminService;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        try{
            C_UserAdmin c_userAdmin =(C_UserAdmin) principalCollection.getPrimaryPrincipal();
            //根据当前用户查询数据库角色
            List<String> AA=ht_c_userAdminService.HTfindidentity(c_userAdmin.getUname());
            if(AA.size()!=0){
                //创建一个set把角色存起来
                Set<String> roles = new HashSet<>();
                for (String r:roles){
                    roles.add(r);
                }
                SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
                //根据角色分配权限
                //定义一个列表用来放权限
                ArrayList<String> permissions  = new ArrayList<>();
                for(String op:roles){
                    //根据用户的角色查询对应的权限
                    List<String> jure = ht_c_userAdminService.HTfindbyJurisdiction(op);
                    if(jure.size()!=0){
                        for(String j:jure){
                            permissions.add(j);
                        }
                    }
                }
                simpleAuthorizationInfo.addStringPermissions(permissions);
                return simpleAuthorizationInfo;
            }
        }catch (Exception e){
            System.out.println("出错了");
        }
        return  null;
    }

    /**
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException   进行认证操作
     */

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户登录的用户名
        String principal = authenticationToken.getPrincipal().toString();
        C_UserAdmin c_userAdmin = ht_c_userAdminService.findHTfindByName(principal);
        if(c_userAdmin==null){
            return  null;
        }
        return new SimpleAuthenticationInfo(c_userAdmin,c_userAdmin.getPwd(),getName());
    }





}
