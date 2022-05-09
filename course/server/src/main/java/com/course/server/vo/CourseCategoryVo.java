package com.course.server.vo;
import lombok.Data;


@Data
public class CourseCategoryVo {

    /**
     * id
     */
    private Integer id;

    /**
     * 课程|course.id
     */
    private String courseId;

    /**
     * 分类|course.id
     */
    private String categoryId;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", categoryId=").append(categoryId);
        sb.append("]");
        return sb.toString();
    }

}
