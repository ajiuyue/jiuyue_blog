package com.jiuyue.blog.utils.web;

import com.jiuyue.blog.constant.ResponseEnum;
import com.jiuyue.blog.pojo.vo.ResponseVO;

/**
 * Create bySeptember
 * 2019/3/7
 * 17:33
 */
//统一响应类
public class ResponseVOUtil {
    /**
     * 成功后返回响应code , msg,数据,比如用户信息集合对象
     * @param object
     * @return
     */
    public static ResponseVO success(Object object){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseEnum.SUCCESS.getCode());
        responseVO.setMsg(ResponseEnum.SUCCESS.getMessage());
        responseVO.setData(object);
        return responseVO;
    }

    /**
     * 成功后返回响应code , msg
     * @return
     */
    public static ResponseVO success(){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseEnum.SUCCESS.getCode());
        responseVO.setMsg(ResponseEnum.SUCCESS.getMessage());
        responseVO.setData(null);
        return responseVO;
    }

    /**
     * 失败后返回响应code , msg
     * @param code
     * @param msg
     * @return
     */
    public static ResponseVO error(Integer code,String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(code);
        responseVO.setMsg(msg);
        return responseVO;
    }

    /**
     * 失败后返回响应code , msg，这里返回的是ResponseEnum定义的异常错误
     * @param responseEnum
     * @return
     */
    public static ResponseVO error(ResponseEnum responseEnum){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(responseEnum.getCode());
        responseVO.setMsg(responseEnum.getMessage());
        return responseVO;
    }
}
