package cn.com.dream.common.shiro;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * token工具类
 *
 * @Author yangjun
 * @Date 2020/12/11
 **/
public class TokenUtil {

    private static final String TOKEN_NAME = "Dream-Auth-Token";

    public static String getToken(HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token) && httpRequest.getAttribute(TOKEN_NAME) != null) {
                token = httpRequest.getAttribute(TOKEN_NAME).toString();
            }
        }
        return token;
    }

}
