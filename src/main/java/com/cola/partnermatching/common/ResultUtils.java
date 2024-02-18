package com.cola.partnermatching.common;

/**
 * 返回工具类
 *
 * @author Maobohe
 * @createData 2024/1/26 14:31
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data
     * @param <T>
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     *
     * @param errorCode
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse<>(errorCode.getCode(), null ,message, description);
    }

    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(), description);
    }

    public static BaseResponse error(int errorCode, String message, String description) {
        return new BaseResponse<>(errorCode, null, message, description);
    }

}
