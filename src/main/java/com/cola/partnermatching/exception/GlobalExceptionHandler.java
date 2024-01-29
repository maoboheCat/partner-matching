package com.cola.partnermatching.exception;

import com.cola.partnermatching.comment.BaseRespsonse;
import com.cola.partnermatching.comment.ErrorCode;
import com.cola.partnermatching.comment.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Maobohe
 * @createData 2024/1/26 15:41
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseRespsonse businessExceptionHandler(BusinessException e) {
        log.error("businessException"+ e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseRespsonse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), "");
    }
}
