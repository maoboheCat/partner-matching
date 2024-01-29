package com.cola.partnermatching.comment;

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
    public static <T> BaseRespsonse<T> success(T data) {
        return new BaseRespsonse<>(0, data, "ok");
    }

    /**
     * 失败
     *
     * @param errorCode
     */
    public static BaseRespsonse error(ErrorCode errorCode) {
        return new BaseRespsonse<>(errorCode);
    }

    public static BaseRespsonse error(ErrorCode errorCode, String message, String description) {
        return new BaseRespsonse<>(errorCode.getCode(), null ,message, description);
    }

    public static BaseRespsonse error(ErrorCode errorCode, String description) {
        return new BaseRespsonse<>(errorCode.getCode(), null, errorCode.getMessage(), description);
    }

    public static BaseRespsonse error(int errorCode, String message, String description) {
        return new BaseRespsonse<>(errorCode, null, message, description);
    }

}
