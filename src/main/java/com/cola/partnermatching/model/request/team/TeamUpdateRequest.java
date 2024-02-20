package com.cola.partnermatching.model.request.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户更新队伍请求体
 * @author Maobohe
 * @createData 2024/2/17 16:10
 */
@Data
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = -554413508804085301L;

    /**
     * 队伍id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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
