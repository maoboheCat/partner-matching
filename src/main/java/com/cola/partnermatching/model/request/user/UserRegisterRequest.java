package com.cola.partnermatching.model.request.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author Maobohe
 * @createData 2024/1/24 14:07
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -5986039310639033933L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
