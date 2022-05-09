package com.course.business.controller.admin;

import com.course.server.service.CourseCategoryService;
import com.course.server.vo.CourseCategoryVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/courseCategory")
public class CourseCategoryController {
    @Resource
    private CourseCategoryService courseCategoryService;

    private static final Logger LOG = LoggerFactory.getLogger(CourseCategoryController.class);
    public static final String BUSINESS_NAME = "课程分类";



    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param courseCategoryVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody CourseCategoryVo courseCategoryVo) {

        ResponseVo responseVo = new ResponseVo();
        courseCategoryService.save(courseCategoryVo);
        responseVo.setContent(courseCategoryVo);
        return responseVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable Integer id) {
        ResponseVo responseVo = new ResponseVo();
        courseCategoryService.delete(id);
        return responseVo;
    }
}
