package com.edu.audit.config;

import com.edu.audit.filter.CORSAuthenticationFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/1/17 14:30
 * @Version: v1.0
 */
@Configuration
public class ShiroConfig {

    private static Logger log = LoggerFactory.getLogger(ShiroConfig.class);




    /**
     * 对shiro的拦截器进行注入
     * <p>
     * securityManager:
     * 所有Subject 实例都必须绑定到一个SecurityManager上,SecurityManager 是 Shiro的核心，初始化时协调各个模块运行。然而，一旦 SecurityManager协调完毕，
     * SecurityManager 会被单独留下，且我们只需要去操作Subject即可，无需操作SecurityManager 。 但是我们得知道，当我们正与一个 Subject 进行交互时，实质上是
     * SecurityManager在处理 Subject 安全操作
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

//        //设置遇到未登录、未授权等情况时候，请求这些地址，返回相应的错误
//        shiroFilter.setLoginUrl("/user/shiroError?errorId=" + Constant.NEED_LOGIN);
//        shiroFilter.setUnauthorizedUrl("/user/shiroError?errorId=" + Constant.NO_UNAUTHORIZED);

        //拦截器，配置访问权限 必须是LinkedHashMap，因为它必须保证有序。滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        Map<String, String> filterMap = new LinkedHashMap<String, String>();

        // 配置不会被拦截的链接 顺序判断
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/shiroError", "anon");
        filterMap.put("/user/reg", "anon");


        //放行swagger
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/v2/**", "anon");
        filterMap.put("/webjars/**", "anon");

        filterMap.put("/doc.html", "anon");



        filterMap.put("/test/**","anon");


        //剩余的请求shiro都拦截
        filterMap.put("/**/*", "authc");

        shiroFilter.setFilterChainDefinitionMap(filterMap);


        //自定义拦截器
        Map<String, Filter> customFilterMap = new LinkedHashMap<>();
        customFilterMap.put("corsAuthenticationFilter", new CORSAuthenticationFilter());
        shiroFilter.setFilters(customFilterMap);

        return shiroFilter;
    }





    /**
     * securityManager 核心配置
     * 安全控制层
     * @return
     */
    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置自定义的realm
        defaultWebSecurityManager.setRealm(myShiroRealm());
        //自定义的shiro session 缓存管理器
        defaultWebSecurityManager.setSessionManager(sessionManager());
        //将缓存对象注入到SecurityManager中
        defaultWebSecurityManager.setCacheManager(ehCacheManager());

        return defaultWebSecurityManager;
    }


    /**
     * 开启shiro 的AOP注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * shiro缓存管理器
     * 1 添加相关的maven支持
     * 2 注册这个bean，将缓存的配置文件导入
     * 3 在securityManager 中注册缓存管理器，之后就不会每次都会去查询数据库了，相关的权限和角色会保存在缓存中，但需要注意一点，更新了权限等操作之后，需要及时的清理缓存
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }


    /**
     * 自定义的 shiro session 缓存管理器，用于跨域等情况下使用 token 进行验证，不依赖于sessionId
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        //将我们继承后重写的shiro session 注册
        ShiroSession shiroSession = new ShiroSession();
        //如果后续考虑多tomcat部署应用，可以使用shiro-redis开源插件来做session 的控制，或者nginx 的负载均衡
        shiroSession.setSessionDAO(new EnterpriseCacheSessionDAO());
        return shiroSession;
    }



    /**
     * 自定义Realm，可以多个
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 配置加密匹配，使用MD5的方式，进行1024次加密
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
}
