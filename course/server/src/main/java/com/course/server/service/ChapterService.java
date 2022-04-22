package com.course.server.service;

import com.course.server.dao.ChapterMapper;
import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    public List<Chapter> selectByExample(ChapterExample example) {
        return chapterMapper.selectByExample(example);

    }
}
