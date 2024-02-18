package com.cola.partnermatching.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通过分页请求参数
 * @author Maobohe
 * @createData 2024/2/17 13:52
 */

@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 709154403863371091L;

    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前页数
     */
    protected int pageNum = 1;


}
