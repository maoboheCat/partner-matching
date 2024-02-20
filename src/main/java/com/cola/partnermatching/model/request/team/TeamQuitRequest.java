package com.cola.partnermatching.model.request.team;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 * @author Maobohe
 * @createData 2024/2/20 13:29
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = -2083670780441603399L;

    /**
     * 队伍id
     */
    private Long id;

}
