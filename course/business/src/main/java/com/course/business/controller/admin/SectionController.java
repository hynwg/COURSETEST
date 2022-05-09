package com.course.business.controller.admin;

import com.course.server.service.SectionService;
import com.course.server.vo.ResponseVo;
import com.course.server.vo.SectionPageVo;
import com.course.server.vo.SectionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/section")
public class SectionController {
    @Resource
    private SectionService sectionService;

    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);
    public static final String BUSINESS_NAME = "小节";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody SectionPageVo sectionPageVo) {
        ResponseVo responseVo = new ResponseVo();
        sectionService.query(sectionPageVo);
        responseVo.setContent(sectionPageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param sectionVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody SectionVo sectionVo) {

        ResponseVo responseVo = new ResponseVo();
        sectionService.save(sectionVo);
        responseVo.setContent(sectionVo);
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
        sectionService.delete(id);
        return responseVo;
    }
}
