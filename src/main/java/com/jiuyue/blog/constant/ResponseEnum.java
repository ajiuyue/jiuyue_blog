package com.jiuyue.blog.constant;

/**
 * Create bySeptember
 * 2019/3/7
 * 17:36
 */
//constants 常量
public enum ResponseEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PARAM_ERROR(2,"参数错误"),
    LOGIN_EXCEPTION(3,"登录异常"),
    USER_NOT_FOUND(4,"用户不存在"),
    PASSWPRD_INCORRECT(5,"密码不正确"),
    INVALID_TOKEN(6, "无效的token"),
    TOKEN_EXPIRED(7, "过期的token"),
    UNAUTHORIZED(8, "没有权限"),
    DELETE_FAILED(9, "删除失败"),
    RESOURCE_NOT_FOUND(10, "资源不存在");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
