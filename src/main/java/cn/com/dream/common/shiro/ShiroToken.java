package cn.com.dream.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * shiroToken
 *
 * @Author yangjun
 * @Date 2020/12/11
 **/
public class ShiroToken implements AuthenticationToken {

    private String token;

    public ShiroToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
