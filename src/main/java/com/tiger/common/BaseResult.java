package com.tiger.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -1242493306307174690L;

    private int code;

    private String message;

    private boolean success;

    protected BaseResult(int code,String message,boolean success){
        this.code = code;
        this.message = message;
        this.success = success;
    }
}