package com.course.server.service;

import com.course.server.dao.CourseContentMapper;
import com.course.server.dao.CourseMapper;
import com.course.server.entity.Course;
import com.course.server.entity.CourseContent;
import com.course.server.entity.CourseExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.CourseContentVo;
import com.course.server.vo.CoursePageVo;
import com.course.server.vo.CourseVo;
import com.course.server.vo.SortVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseCategoryService courseCategoryService;
    @Resource
    private CourseContentMapper courseContentMapper;

//    @Resource
//    private TeacherService teacherService;

    @Resource
    private ChapterService chapterService;

    @Resource
    private SectionService sectionService;


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
    @Transactional
    public void save(CourseVo courseVo) {
        Course course = CopyUtil.copy(courseVo, Course.class);
        if (course.getId() == null) {
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
        courseCategoryService.saveBatch(course.getId(), courseVo.getCategoryList());
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public CourseContentVo findContent(Integer id) {
        CourseContent content = courseContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CourseContentVo.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(CourseContentVo courseContentVo) {
        CourseContent content = CopyUtil.copy(courseContentVo, CourseContent.class);
        int i = courseContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = courseContentMapper.insert(content);
        }
        return i;
    }

    /**
     * 排序
     *
     * @param sortDto
     */
    @Transactional
    public void sort(SortVo sortVo) {
        // 修改当前记录的排序值
        courseMapper.updateSort(sortVo);

        // 如果排序值变大
        if (sortVo.getNewSort() > sortVo.getOldSort()) {
            courseMapper.moveSortsForward(sortVo);
        }

        // 如果排序值变小
        if (sortVo.getNewSort() < sortVo.getOldSort()) {
            courseMapper.moveSortsBackward(sortVo);
        }
    }
}
