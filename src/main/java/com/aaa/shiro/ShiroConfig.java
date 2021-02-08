package com.aaa.shiro;
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Properties;

@Configuration
public class ShiroConfig {
    //添加Shiro内置过滤器
    /**
     * Shiro内置过滤器，可以实现权限相关的拦截器
     *    常用的过滤器：
     *       anon: 无需认证（登录）可以访问
     *       authc: 必须认证才可以访问
     *       user: 如果使用rememberMe的功能可以直接访问
     *       perms： 该资源必须得到资源权限才可以访问
     *       role: 该资源必须得到角色权限才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean   shiroFilterFactoryBean =new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //LinkedHashMap 有顺序的存 取出来的也是按顺序取

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        //登录提交不需要验证
//        map.put("/admin/ht_login_submit","anon");
//        map.put("/admin/ht_login_show","anon");
//        map.put("/ht_c_folkopera/ht_folk_show","anon");
//        map.put("/ht_c_folkopera/ht_findvague","anon");
//        map.put("/ht_user/ht_usershow","anon");
//        map.put("/ht_user/ht_findbystate","anon");
        //static下面的静态资源不需要拦截
//        map.put("/css/**","anon");
//        map.put("/vendor/**","anon");

        //设置要登录的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/ht_login_show");
        //其他页面需要验证
        map.put("/*/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myRealm);
        return dwsm;
    }




    /*
    *
    * 自定义Realm
    *
    * */

    @Bean(name="myRealm")
    public  MyRealm myRealm()
    {
        return  new MyRealm();
    }
    /*
    * 配置SShiroDialect，用于thymeleaf和shiro标签的配合使用
    *
    * */

//    @Bean
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }


    /**
     * 使用shiro的判断权限角色的注解要使用的bean
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator()
    {
        DefaultAdvisorAutoProxyCreator  advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator ();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor advisor(DefaultWebSecurityManager SecurityManager)
    {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(SecurityManager);
        return advisor;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        /*未授权处理页*/
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/login_show");
        /*身份没有验证*/
        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException", "/login_show");
        resolver.setExceptionMappings(properties);
        return resolver;
    }


}
