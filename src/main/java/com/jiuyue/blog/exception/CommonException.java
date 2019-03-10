package com.jiuyue.blog.exception;

import com.jiuyue.blog.constant.ResponseEnum;
import lombok.Getter;

/**
 * Create bySeptember
 * 2019/3/7
 * 17:49
 */
@Getter
public class CommonException extends RuntimeException{
    private Integer code;
    public CommonException(ResponseEnum responseEnum){
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }
    public CommonException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
