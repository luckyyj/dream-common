package cn.com.dream.common.base.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果对象
 *
 * @Author yangjun
 * @Date 2020/1/19
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    /**
     * 结果code
     */
    private String code;

    /**
     * 结果信息
     */
    private String msg;

    /**
     * 结果数据
     */
    private Object data;

}
