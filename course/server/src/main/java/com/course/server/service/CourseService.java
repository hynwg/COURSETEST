package com.course.server.service;

import com.course.server.dao.CourseMapper;
import com.course.server.entity.Course;
import com.course.server.entity.CourseExample;
import com.course.server.vo.CourseVo;
import com.course.server.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
        import java.util.Date;

@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;

    /**
     * 分页查询
     *
     * @param pageVo
     */
    public void query(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getSize());
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("sort asc");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        pageVo.setTotal(pageInfo.getTotal());

        List<CourseVo> list = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            CourseVo courseVo = new CourseVo();
            BeanUtils.copyProperties(course, courseVo);
            list.add(courseVo);
        }
        pageVo.setList(list);
    }

    /**
     * 保存
     *
     * @param courseVo
     */
    public void save(CourseVo courseVo) {
        Course course = CopyUtil.copy(courseVo, Course.class);
        if (StringUtil.isEmpty(course.getId())) {
            Date now = new Date();
            course.setCreatedAt(now);
            course.setUpdatedAt(now);
            course.setId(UuidUtil.getShortUuid());
            courseMapper.insert(course);
        } else {
            course.setUpdatedAt(new Date());
            courseMapper.updateByPrimaryKey(course);
        }
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
