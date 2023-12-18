package com.goya.core.handler;

import com.goya.core.domain.Result;
import com.goya.core.enums.ReturnCode;
import com.goya.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author limoum0u
 * @date 23/11/9 10:49
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return Result.ofFail(ReturnCode.USER_ERROR_A0500);
    }
}
