package com.tiger.exception;

import com.tiger.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        log.error("GlobalExceptionHandler message:{}, Exception:{}", e.getMessage(), e);
        if (e instanceof BusException) {//业务异常
            BusException busException = (BusException) e;
            return Result.error(busException.getCode(),busException.getMessage());
        }

        if (e instanceof MethodArgumentNotValidException) {//@Validated 校验异常
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            BindingResult result = exception.getBindingResult();
            String message = "";
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                if (!CollectionUtils.isEmpty(errors)) {
                    FieldError fieldError = (FieldError) errors.get(0);
                    message = fieldError.getField() + fieldError.getDefaultMessage();
                }
            }
            return Result.error(ResultErrorCodeEnum.PARAM_ERROR.getCode(), message);
        }

        if(e instanceof HttpRequestMethodNotSupportedException){
            return Result.error(ResultErrorCodeEnum.REQUEST_METHOD.getCode(), ResultErrorCodeEnum.REQUEST_METHOD.getMessage());
        }

        if (e instanceof HttpMessageNotReadableException) {//json反序列化失败异常
            return Result.error(ResultErrorCodeEnum.SERIALIZATIO_ERROR.getCode(),ResultErrorCodeEnum.SERIALIZATIO_ERROR.getMessage());
        }

        if (e instanceof MaxUploadSizeExceededException) {//上传文件超过限制异常
            return Result.error(ResultErrorCodeEnum.FILE_TOO_MAX_ERROR.getCode(),ResultErrorCodeEnum.FILE_TOO_MAX_ERROR.getMessage());
        }

        //其余异常
        return Result.error(ResultErrorCodeEnum.SYSTEM_BUSY.getCode(),ResultErrorCodeEnum.SYSTEM_BUSY.getMessage());

    }
}