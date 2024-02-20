package com.cola.partnermatching.model.request.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户添加队伍请求体
 * @author Maobohe
 * @createData 2024/2/18 16:10
 */
@Data
public class TeamAddRequest implements Serializable {

    private static final long serialVersionUID = -4178039846031764511L;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 0 - 公开, 1 - 私有, 2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;

}
