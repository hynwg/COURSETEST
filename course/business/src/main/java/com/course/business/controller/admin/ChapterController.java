package com.course.business.controller.admin;

import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVo;
import com.course.server.vo.PageVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

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
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody ChapterVo chapterVo) {
        ResponseVo responseVo = new ResponseVo();
        chapterService.save(chapterVo);
        responseVo.setContent(chapterVo);
        return responseVo;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable String id) {
        ResponseVo responseVo = new ResponseVo();
        chapterService.delete(id);
        return responseVo;
    }
}
