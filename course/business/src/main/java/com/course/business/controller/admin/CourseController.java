package com.course.business.controller.admin;

import com.course.server.service.CourseCategoryService;
import com.course.server.service.CourseService;
import com.course.server.vo.CourseCategoryVo;
import com.course.server.vo.CoursePageVo;
import com.course.server.vo.CourseVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/course")
public class CourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private CourseCategoryService courseCategoryService;

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
    public static final String BUSINESS_NAME = "课程";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody CoursePageVo coursePageVo) {
        ResponseVo responseVo = new ResponseVo();
        courseService.query(coursePageVo);
        responseVo.setContent(coursePageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param courseVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody CourseVo courseVo) {

        ResponseVo responseVo = new ResponseVo();
        courseService.save(courseVo);
        responseVo.setContent(courseVo);
        return responseVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable String id) {
        ResponseVo responseVo = new ResponseVo();
        courseService.delete(id);
        return responseVo;
    }

    /**
     * 查找课程下所有分类
     * @param courseId
     */
    @PostMapping("/list-category/{courseId}")
    public ResponseVo listCategory(@PathVariable(value = "courseId") Integer courseId) {
        ResponseVo responseDto = new ResponseVo();
        List<CourseCategoryVo> dtoList = courseCategoryService.listByCourse(courseId);
        responseDto.setContent(dtoList);
        return responseDto;
    }
}
