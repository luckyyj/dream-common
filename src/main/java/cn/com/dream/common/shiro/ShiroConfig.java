package cn.com.dream.common.shiro;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置
 *
 * @Author yangjun
 * @Date 2020/12/9
 **/
@Configuration
public class ShiroConfig {

    @Bean(name = "securityManager")
    public SecurityManager securityManager(AuthorizingRealm authorizingRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authorizingRealm);
        return securityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(ShiroFilterPathAdapter adapter, SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        setFilterPathMap(adapter.getAnonPath(), filterChainDefinitionMap, "anon");
        setFilterPathMap(adapter.getAuthcPath(), filterChainDefinitionMap, "authc");
        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        //自定义token权限过滤
        filterMap.put("authc", new ShiroTokenFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 设置过滤地址
     *
     * @param pathArray     地址数组
     * @param filterPathMap 地址Map
     * @param value         地址Map的value值
     */
    private void setFilterPathMap(String[] pathArray, Map<String, String> filterPathMap, String value) {
        if (ArrayUtils.isNotEmpty(pathArray)) {
            for (String anonPath : pathArray) {
                filterPathMap.put(anonPath, value);
            }
        }
    }

}
