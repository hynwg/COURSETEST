package com.course.business.controller;

import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    @RequestMapping("/chapter/select")
    public List<Chapter> selectByExample(ChapterExample example) {
        return chapterService.selectByExample(example);
    }

}
