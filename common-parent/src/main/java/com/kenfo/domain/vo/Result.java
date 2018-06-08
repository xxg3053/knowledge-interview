package com.kenfo.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kf.util
 * @Description: TODO
 * @date 2018/6/4 下午7:18
 */
@Data
@ApiModel(description = "返回结果")
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result(){

    }

    public Result(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Result(String msg, T data) {
        super();
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
