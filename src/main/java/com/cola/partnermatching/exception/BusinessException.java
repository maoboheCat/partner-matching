package com.cola.partnermatching.exception;

import com.cola.partnermatching.comment.ErrorCode;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author Maobohe
 * @createData 2024/1/26 15:14
 */
@Getter
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 5223051469771182982L;

    private final int code;

    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

}
