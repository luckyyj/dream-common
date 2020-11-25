package cn.com.dream.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果枚举
 *
 * @Author yangjun
 * @Date 2020/1/19
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {

    DEFAULT_ERROR("-1", "未知错误");

    private String code;

    private String msg;

}
