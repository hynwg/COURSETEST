package com.course.server.vo;

import lombok.Data;

@Data
public class SortVo {
    /**
     * ID
     */
    private String id;

    /**
     * 当前排序
     */
    private int oldSort;

    /**
     * 新排序
     */
    private int newSort;

}
