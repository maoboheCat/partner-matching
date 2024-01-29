package com.cola.partnermatching.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author Maobohe
 * @createData 2024/1/24 14:07
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -8018351812306623996L;

    private String userAccount;

    private String userPassword;

}
