package com.cola.partnermatching.model.request.team;

import lombok.Data;

import java.io.Serializable;

/**
 * 队伍删除请求体
 * @author Maobohe
 * @createData 2024/2/20 14:52
 */
@Data
public class TeamDeleteRequest implements Serializable {

    private static final long serialVersionUID = 3176659607353584860L;

    /**
     * 队伍id
     */
    private Long id;
}
