package com.cola.partnermatching.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户包装类（脱敏）
 * @author Maobohe
 * @createData 2024/2/17 18:56
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -7288908297921932841L;
    /**
     * 用户id
     */
    private long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 用户性别
     */
    private Integer gender;

    /**
     * 标签列表
     */
    private String tags;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 用户权限
     */
    private Integer userRole;

    /**
     * 用户描述
     */
    private String profile;
}
