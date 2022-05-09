package com.course.server.service;

import com.course.server.dao.SectionMapper;
import com.course.server.entity.Section;
import com.course.server.entity.SectionExample;
import com.course.server.enums.SectionChargeEnum;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.SectionPageVo;
import com.course.server.vo.SectionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SectionService {
    @Resource
    private SectionMapper sectionMapper;

    /**
     * 分页查询
     *
     * @param sectionPageVo
     */
    public void query(SectionPageVo  sectionPageVo) {
        PageHelper.startPage(sectionPageVo.getPage(), sectionPageVo.getSize());
        SectionExample  sectionExample= new SectionExample();
        SectionExample.Criteria criteria = sectionExample.createCriteria();
        if (!StringUtils.isEmpty(sectionPageVo.getCourseId())) {
            criteria.andCourseIdEqualTo(sectionPageVo.getCourseId());
        }
        if (!StringUtils.isEmpty(sectionPageVo.getChapterId())) {
            criteria.andChapterIdEqualTo(sectionPageVo.getChapterId());
        }
        sectionExample.setOrderByClause("sort asc");
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        sectionPageVo.setTotal(pageInfo.getTotal());
        List<SectionVo> sectionVoList = CopyUtil.copyList(sectionList, SectionVo.class);
        sectionPageVo.setList(sectionVoList);
    }

    /**
     * 保存
     *
     * @param sectionVo
     */
    public void save(SectionVo sectionVo) {
        Section section = CopyUtil.copy(sectionVo, Section.class);
        if (StringUtil.isEmpty(section.getId())) {
            Date now = new Date();
            section.setCreatedAt(now);
            section.setUpdatedAt(now);
            section.setId(UuidUtil.getShortUuid());
            section.setCharge(SectionChargeEnum.CHARGE.getCode());
            sectionMapper.insert(section);
        } else {
            section.setUpdatedAt(new Date());
            sectionMapper.updateByPrimaryKey(section);
        }
        //为了保持事务一致性，增加事务处理
        sectionMapper.updateCourseTime(section.getCourseId());
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}
