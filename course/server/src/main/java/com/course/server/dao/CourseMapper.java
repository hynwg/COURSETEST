package com.course.server.dao;

import com.course.server.entity.Course;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {


    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(Course course);

    Course selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
