package cn.com.dream.common.shiro;

/**
 * shiro过滤路径适配器
 *
 * @Author yangjun
 * @Date 2020/12/9
 **/
public interface ShiroFilterPathAdapter {

    String[] getAnonPath();

    String[] getAuthcPath();

}
