package com.course.business.controller.admin;

import com.course.server.service.TeacherService;
import com.course.server.vo.ResponseVo;
import com.course.server.vo.TeacherPageVo;
import com.course.server.vo.TeacherVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    private static final Logger LOG = LoggerFactory.getLogger(TeacherController.class);
    public static final String BUSINESS_NAME = "讲师";

    /**
     * 列表查询
     */
    @PostMapping("/all")
    public ResponseVo all() {
        ResponseVo responseVo = new ResponseVo();
        List<TeacherVo> teacherVoList = teacherService.all();
        responseVo.setContent(teacherVoList);
        return responseVo;
    }

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody TeacherPageVo teacherPageVo) {
        ResponseVo responseVo = new ResponseVo();
        teacherService.query(teacherPageVo);
        responseVo.setContent(teacherPageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param teacherVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody TeacherVo teacherVo) {

        ResponseVo responseVo = new ResponseVo();
        teacherService.save(teacherVo);
        responseVo.setContent(teacherVo);
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
        teacherService.delete(id);
        return responseVo;
    }
}
