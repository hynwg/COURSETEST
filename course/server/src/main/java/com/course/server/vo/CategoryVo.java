package com.course.server.vo;
import lombok.Data;


@Data
public class CategoryVo {

    /**
     * id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer parent;

    /**
     * 名称
     */
    private String name;

    /**
     * 顺序
     */
    private Integer sort;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parent=").append(parent);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }

}
