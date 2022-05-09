package com.course.server.entity;

import lombok.Data;

@Data
public class CourseCategory {
    private Integer id;

    private Integer courseId;

    private Integer categoryId;

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
