package com.course.server.service;

import com.course.server.dao.SectionMapper;
import com.course.server.entity.Section;
import com.course.server.entity.SectionExample;
import com.course.server.enums.SectionChargeEnum;
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
        import java.util.Date;

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
        SectionExample  sectionExample= new SectionExample();
        sectionExample.setOrderByClause("sort asc");
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
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
