package com.course.business.controller;

import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    @RequestMapping("/select")
    public List<ChapterVo> selectByExample(ChapterExample example) {
      return chapterService.selectByExample(example);

    }

}
