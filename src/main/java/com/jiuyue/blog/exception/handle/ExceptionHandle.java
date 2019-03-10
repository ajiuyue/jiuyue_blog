package com.jiuyue.blog.exception.handle;

import com.jiuyue.blog.constant.ResponseEnum;
import com.jiuyue.blog.exception.CommonException;
import com.jiuyue.blog.pojo.vo.ResponseVO;
import com.jiuyue.blog.utils.web.ResponseVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create bySeptember
 * 2019/3/7
 * 18:29
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO handle(Exception e){
        //如果是我们自定义的异常
        //instanceof判断value是不是属于这个Class类的
        if (e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            return ResponseVOUtil.error(commonException.getCode(),commonException.getMessage());
        }else {
            log.error("【系统异常】{}",e);
            return ResponseVOUtil.error(ResponseEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }

    }
}
