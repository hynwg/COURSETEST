package com.course.server.vo;

import lombok.Data;

@Data
public class SectionPageVo extends PageVo {

    /**
     * 课程|course.id
     */
    private String courseId;

    /**
     * 大章|chapter.id
     */
    private String chapterId;



}
