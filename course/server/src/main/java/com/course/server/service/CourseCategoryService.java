package com.course.server.service;

import com.course.server.dao.CourseCategoryMapper;
import com.course.server.entity.CourseCategory;
import com.course.server.entity.CourseCategoryExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.CategoryVo;
import com.course.server.vo.CourseCategoryPageVo;
import com.course.server.vo.CourseCategoryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseCategoryService {
    @Resource
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * 分页查询
     *
     * @param courseCategoryPageVo
     */
    public void query(CourseCategoryPageVo courseCategoryPageVo) {
        PageHelper.startPage(courseCategoryPageVo.getPage(), courseCategoryPageVo.getSize());
        CourseCategoryExample courseCategoryExample = new CourseCategoryExample();
        List<CourseCategory> courseCategoryList = courseCategoryMapper.selectByExample(courseCategoryExample);
        PageInfo<CourseCategory> pageInfo = new PageInfo<>(courseCategoryList);
        courseCategoryPageVo.setTotal(pageInfo.getTotal());
        List<CourseCategoryVo> courseCategoryVoList = CopyUtil.copyList(courseCategoryList, CourseCategoryVo.class);
        courseCategoryPageVo.setList(courseCategoryVoList);
    }

    /**
     * 保存
     *
     * @param courseCategoryVo
     */
    public void save(CourseCategoryVo courseCategoryVo) {
        CourseCategory courseCategory = CopyUtil.copy(courseCategoryVo, CourseCategory.class);
        if (courseCategory.getId() == null) {

            courseCategoryMapper.insert(courseCategory);
        } else {
            courseCategoryMapper.updateByPrimaryKey(courseCategory);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id) {
        courseCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据某一课程，先清空课程分类，再保存课程分类
     * @param dtoList
     */
    @Transactional
    public void saveBatch(Integer courseId, List<CategoryVo> dtoList) {
        CourseCategoryExample example = new CourseCategoryExample();
        example.createCriteria().andCourseIdEqualTo(courseId);
        courseCategoryMapper.deleteByExample(example);
        for (int i = 0, l = dtoList.size(); i < l; i++) {
            CategoryVo categoryVo = dtoList.get(i);
            CourseCategory courseCategory = new CourseCategory();
            courseCategory.setCourseId(courseId);
            courseCategory.setCategoryId(categoryVo.getId());
            courseCategoryMapper.insert(courseCategory);
        }
    }

    /**
     * 查找课程下所有分类
     * @param courseId
     */
    public List<CourseCategoryVo> listByCourse(Integer courseId) {
        CourseCategoryExample example = new CourseCategoryExample();
        example.createCriteria().andCourseIdEqualTo(courseId);
        List<CourseCategory> courseCategoryList = courseCategoryMapper.selectByExample(example);
        return CopyUtil.copyList(courseCategoryList, CourseCategoryVo.class);
    }
}
