package top.lover.hyperlink.config.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shanfeng
 * @create 2019-12-27 11:36
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /*
        anon: 无需认证即可访问
        authc: 需要认证才可访问
        user: 点击“记住我”功能可访问
        perms: 拥有权限才可以访问
        role: 拥有某个角色权限才能访问
        * */
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/menu/*", "anon");
//        filterChainDefinitionMap.put("/users/*", "anon");
        filterChainDefinitionMap.put("/users/edit/*", "anon");
        filterChainDefinitionMap.put("/users/delete/*", "anon");
        filterChainDefinitionMap.put("userslist", "perms");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/api/**", "anon");

        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/user/**", "authc");
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    /**
     * 配置安全管理器，并且注入Realm域
     * @param realm
     * @return
     */
   /* @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager  = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager ;
    }*/
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("realm")Realm realm
            ,@Qualifier("sessionManager") SessionManager sessionManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        manager.setSessionManager(sessionManager);
        return manager;
    }

    @Bean("sessionManager")
    public SessionManager sessionManager(){
        CustomSessionManager manager = new CustomSessionManager();
		/*使用了shiro自带缓存，
		如果设置 redis为缓存需要重写CacheManager（其中需要重写Cache）
		manager.setCacheManager(this.RedisCacheManager());*/
        manager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return manager;
    }

    /**
     *  Credentials：凭证/证书 ---
     * 配置Realm域，注入密码比较器
     * @param credentialsMatcher
     * @return
     */
    @Bean("realm")
    public CustomRealm realm(CredentialsMatcher credentialsMatcher) {
        CustomRealm customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(credentialsMatcher);
        return customRealm;
    }
    /**
     * 自定义密码比较器
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        return new CustCredentialsMatcher();
    }
    /**
     * 开启shiro aop注解支持
     * 使用代理方式;所以需要开启代码支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 开启cglib代理
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}
