package com.cola.partnermatching.comment;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @author Maobohe
 * @createData 2024/1/26 14:25
 */

@Data
public class BaseRespsonse<T> implements Serializable {

    private static final long serialVersionUID = 4752396857162581465L;

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseRespsonse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseRespsonse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = "";
    }

    public BaseRespsonse(int code, T data) {
        this.code = code;
        this.data = data;
        this.message = "";
        this.description = "";
    }

    public BaseRespsonse(ErrorCode errorCode) {
        this(errorCode.getCode(), null ,errorCode.getMessage(), errorCode.getDescription());
    }
}
