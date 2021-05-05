package com.tiger.common;


public class Result<T> extends BaseResult {

    private T data;

    private Result(int code, String message, boolean success) {
        super(code, message, success);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> error(int code, String message,T data) {
        Result<T> result = build(code,false,message);
        result.setData(data);
        return result;
    }

    public static Result error(int code, String message) {
        return build(code,false,message);
    }

    public static Result error(String message) {
        return build(1000,false,message);
    }

    public static Result error() {
        return build(1000,false,"失败");
    }

    public static Result success(){
        return build(0,true,null);
    }

    public static Result success(String message){
        return build(0,true,message);
    }

    public static <T> Result<T> success(T data){
        Result<T> result = build(0,true,null);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String message,T data){
        Result<T> result = build(0,true,message);
        result.setData(data);
        return result;
    }

    private static <T> Result<T> build(int code,boolean success,String message){
        Result<T> result = new Result(code,message,success);
        return result;
    }
}