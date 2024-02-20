package com.cola.partnermatching.model.request.team;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户加入队伍请求体
 * @author Maobohe
 * @createData 2024/2/18 16:10
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 3305200731586256083L;

    /**
     * 队伍id
     */
    private Long id;

    /**
     * 密码
     */
    private String password;

}
