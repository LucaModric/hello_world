package com.tiger.exception;

public enum ResultErrorCodeEnum {

    PARAM_ERROR(1001,"参数错误"),

    SERIALIZATIO_ERROR(1002,"序列化异常"),

    FILE_TOO_MAX_ERROR(1003,"文件太大"),

    SYSTEM_BUSY(1004,"系统繁忙，请稍后再试"),

    REQUEST_METHOD(1005,"请求类型错误"),

    RE_LOGIN(401,"请重新登录");

    private int code;

    private String message;

    ResultErrorCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
