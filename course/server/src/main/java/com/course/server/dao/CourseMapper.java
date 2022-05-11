package com.course.server.dao;

import com.course.server.entity.Course;
import com.course.server.entity.CourseExample;
import com.course.server.vo.SortVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    //修改当前记录的排序值
    int updateSort(SortVo sortVo);
    // 如果排序值变大
    int moveSortsBackward(SortVo sortVo);
    // 如果排序值变小
    int moveSortsForward(SortVo sortVo);
}
