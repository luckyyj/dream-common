package cn.com.dream.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常
 *
 * @Author yangjun
 * @Date 2020/1/19
 **/

@Data
public class BaseException extends RuntimeException {

    /**
     * 异常编码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public BaseException(String code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
