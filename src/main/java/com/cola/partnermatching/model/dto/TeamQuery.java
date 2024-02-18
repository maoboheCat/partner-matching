package com.cola.partnermatching.model.dto;

import com.cola.partnermatching.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 队伍查询封装类
 * @author Maobohe
 * @createData 2024/2/16 20:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeamQuery extends PageRequest {

    private static final long serialVersionUID = -2759114214373368383L;

    /**
     * 队伍id
     */
    private Long id;

    /**
     * 搜索关键词（同时对队伍名称和描述搜索）
     */
    private String searchText;

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
     * 用户id
     */
    private Long userId;

    /**
     * 0 - 公开, 1 - 私有, 2 - 加密
     */
    private Integer status;
}
