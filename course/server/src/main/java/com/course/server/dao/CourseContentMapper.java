package com.course.server.dao;

import com.course.server.entity.CourseContent;
import com.course.server.entity.CourseContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseContentMapper {
    long countByExample(CourseContentExample example);

    int deleteByExample(CourseContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseContent record);

    int insertSelective(CourseContent record);

    List<CourseContent> selectByExampleWithBLOBs(CourseContentExample example);

    List<CourseContent> selectByExample(CourseContentExample example);

    CourseContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseContent record, @Param("example") CourseContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseContent record, @Param("example") CourseContentExample example);

    int updateByExample(@Param("record") CourseContent record, @Param("example") CourseContentExample example);

    int updateByPrimaryKeySelective(CourseContent record);

    int updateByPrimaryKeyWithBLOBs(CourseContent record);

}
