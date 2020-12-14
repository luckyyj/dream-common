package cn.com.dream.common.exception;

import cn.com.dream.common.base.enums.ResultEnum;
import cn.com.dream.common.base.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 *
 * @Date 2020/1/19
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 异常处理
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception exception) {
        log.error(ResultEnum.DEFAULT_ERROR.getMsg(), exception);
        return Result.builder().code(ResultEnum.DEFAULT_ERROR.getCode()).msg(ResultEnum.DEFAULT_ERROR.getMsg()).build();
    }

    /**
     * 自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public Result baseExceptionHandler(BaseException exception) {
        log.error(exception.getMsg(), exception);
        return Result.builder().code(exception.getCode()).msg(exception.getMsg()).build();
    }

}
