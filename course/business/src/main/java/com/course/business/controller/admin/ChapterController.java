package com.course.business.controller.admin;

import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVo;
import com.course.server.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @RequestMapping("/query")
    public PageVo query(@RequestBody PageVo pageVo) {
        LOG.info("pageVo:{}",pageVo);
        chapterService.query(pageVo);
        return pageVo;
    }

}
