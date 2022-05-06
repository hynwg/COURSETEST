package com.course.business.controller.admin;

import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVo;
import com.course.server.vo.PageVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.course.server.util.ValidatorUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    public static final String BUSINESS_NAME = "大章";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody PageVo pageVo) {
        LOG.info("pageVo:{}", pageVo);
        ResponseVo responseVo = new ResponseVo();
        chapterService.query(pageVo);
        responseVo.setContent(pageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param chapterVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody ChapterVo chapterVo) {
        // 保存校验
        ValidatorUtil.require(chapterVo.getName(), "名称");
        ValidatorUtil.require(chapterVo.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterVo.getCourseId(), "课程ID", 1, 8);

        ResponseVo responseVo = new ResponseVo();
        chapterService.save(chapterVo);
        responseVo.setContent(chapterVo);
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
        chapterService.delete(id);
        return responseVo;
    }
}
