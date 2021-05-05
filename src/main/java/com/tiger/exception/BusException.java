package com.tiger.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一业务异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusException extends RuntimeException {

    private int code;

    private String message;

    public BusException(ResultErrorCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }
}