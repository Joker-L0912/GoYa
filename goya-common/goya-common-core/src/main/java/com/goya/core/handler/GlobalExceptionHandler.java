package com.goya.core.handler;

import com.goya.core.domain.Result;
import com.goya.core.enums.ReturnCode;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author limoum0u
 * @date 23/12/12 17:24
 */
@Order(999)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.ofFail(ReturnCode.SYSTEM_ERROR_B0001);
    }
}
