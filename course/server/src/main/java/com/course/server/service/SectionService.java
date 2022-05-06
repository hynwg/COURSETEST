package com.course.server.service;

import com.course.server.dao.SectionMapper;
import com.course.server.entity.Section;
import com.course.server.entity.SectionExample;
import com.course.server.vo.SectionVo;
import com.course.server.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class SectionService {
    @Resource
    private SectionMapper sectionMapper;

    /**
     * 分页查询
     *
     * @param pageVo
     */
    public void query(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getSize());
        SectionExample example = new SectionExample();
        List<Section> sectionList = sectionMapper.selectByExample(example);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageVo.setTotal(pageInfo.getTotal());

        List<SectionVo> list = new ArrayList<>();
        for (int i = 0; i < sectionList.size(); i++) {
            Section section = sectionList.get(i);
            SectionVo sectionVo = new SectionVo();
            BeanUtils.copyProperties(section, sectionVo);
            list.add(sectionVo);
        }
        pageVo.setList(list);
    }

    /**
     * 保存
     *
     * @param sectionVo
     */
    public void save(SectionVo sectionVo) {
        Section section = CopyUtil.copy(sectionVo, Section.class);
        if (StringUtil.isEmpty(section.getId())) {
            section.setId(UuidUtil.getShortUuid());
            sectionMapper.insert(section);
        } else {
            sectionMapper.updateByPrimaryKey(section);
        }
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
