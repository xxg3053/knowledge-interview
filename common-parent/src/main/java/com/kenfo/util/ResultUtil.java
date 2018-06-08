package com.kenfo.util;


import com.kenfo.domain.vo.Result;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kf.util
 * @Description: 返回前端结果
 * @date 2018/6/4 下午7:27
 */
public class ResultUtil {

    public static final Integer OK = 0;
    public static final Integer Error = -1;
    public static final String SUCCESS = "success";

    public static Result success(){
        return new Result(OK, SUCCESS);
    }

    public static<T> Result success(T data){
        return new Result(OK,SUCCESS, data);
    }

    public static Result fail(String msg){
        return new Result(Error, msg);
    }

    public static Result fail(int code, String msg){
        return new Result(code, msg);
    }

}
