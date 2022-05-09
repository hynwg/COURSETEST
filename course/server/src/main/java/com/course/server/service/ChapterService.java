package com.course.server.service;

import com.course.server.dao.ChapterMapper;
import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.ChapterPageVo;
import com.course.server.vo.ChapterVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    /**
     * 分页查询
     *
     * @param chapterPageVo
     */
    public void query(ChapterPageVo chapterPageVo) {
        PageHelper.startPage(chapterPageVo.getPage(), chapterPageVo.getSize());
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        if (!StringUtils.isEmpty(chapterPageVo.getCourseId())) {
            criteria.andCourseIdEqualTo(chapterPageVo.getCourseId());
        }
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        chapterPageVo.setTotal(pageInfo.getTotal());
        List<ChapterVo> chapterDtoList = CopyUtil.copyList(chapterList, ChapterVo.class);
        chapterPageVo.setList(chapterDtoList);
    }

    /**
     * 保存
     *
     * @param chapterVo
     */
    public void save(ChapterVo chapterVo) {
        Chapter chapter = CopyUtil.copy(chapterVo, Chapter.class);
        if (StringUtil.isEmpty(chapter.getId())) {
           // chapter.setId(UuidUtil.getShortUuid());
            chapterMapper.insert(chapter);
        } else {
            chapterMapper.updateByPrimaryKey(chapter);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }
}
