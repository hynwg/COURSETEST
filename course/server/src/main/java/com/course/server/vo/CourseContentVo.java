package com.course.server.vo;
import lombok.Data;


@Data
public class CourseContentVo {

    /**
     * 课程id
     */
    private Integer id;

    /**
     * 课程内容
     */
    private String content;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

}
