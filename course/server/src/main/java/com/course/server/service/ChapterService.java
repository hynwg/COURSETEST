package com.course.server.service;

import com.course.server.dao.ChapterMapper;
import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.vo.ChapterVo;
import com.course.server.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    public void query(PageVo pageVo ) {
        PageHelper.startPage(pageVo.getPage(),pageVo.getSize());
        ChapterExample example=new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(example);
        PageInfo<Chapter> pageInfo=new PageInfo<>(chapterList);
        pageVo.setTotal(pageInfo.getTotal());

        List<ChapterVo> list = new ArrayList<>();
        for (int i = 0; i < chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            list.add(chapterVo);
        }
        pageVo.setList(list);
     }
}
