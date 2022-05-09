package com.course.server.service;

import com.course.server.dao.CourseMapper;
import com.course.server.entity.Course;
import com.course.server.entity.CourseExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.CoursePageVo;
import com.course.server.vo.CourseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseCategoryService courseCategoryService;


    /**
     * 分页查询
     *
     * @param coursePageVo
     */
    public void query(CoursePageVo coursePageVo) {
        PageHelper.startPage(coursePageVo.getPage(), coursePageVo.getSize());
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("sort asc");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        coursePageVo.setTotal(pageInfo.getTotal());
        List<CourseVo> courseVoList = CopyUtil.copyList(courseList, CourseVo.class);
        coursePageVo.setList(courseVoList);
    }

    /**
     * 保存
     *
     * @param courseVo
     */
    public void save(CourseVo courseVo) {
        Course course = CopyUtil.copy(courseVo, Course.class);
        if (course.getId()==null) {
            Date now = new Date();
            course.setCreatedAt(now);
            course.setUpdatedAt(now);
            // course.setId(UuidUtil.getShortUuid());
            courseMapper.insert(course);
        } else {
            course.setUpdatedAt(new Date());
            courseMapper.updateByPrimaryKey(course);
        }
        // 批量保存课程分类
        courseCategoryService.saveBatch(course.getId(), courseVo.getCategorys());
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}
