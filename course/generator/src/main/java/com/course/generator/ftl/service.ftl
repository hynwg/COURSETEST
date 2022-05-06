package com.course.server.service;

import com.course.server.dao.${Domain}Mapper;
import com.course.server.entity.${Domain};
import com.course.server.entity.${Domain}Example;
import com.course.server.vo.${Domain}Vo;
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
<#list typeSet as type>
    <#if type=='Date'>
        import java.util.Date;
    </#if>
</#list>

@Service
public class ${Domain}Service {
    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    /**
     * 分页查询
     *
     * @param pageVo
     */
    public void query(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
<#list fieldList as field>
    <#if field.nameHump=='sort'>
        ${domain}Example.setOrderByClause("sort asc");
    </#if>
</#list>
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);
        pageVo.setTotal(pageInfo.getTotal());

        List<${Domain}Vo> list = new ArrayList<>();
        for (int i = 0; i < ${domain}List.size(); i++) {
            ${Domain} ${domain} = ${domain}List.get(i);
            ${Domain}Vo ${domain}Vo = new ${Domain}Vo();
            BeanUtils.copyProperties(${domain}, ${domain}Vo);
            list.add(${domain}Vo);
        }
        pageVo.setList(list);
    }

    /**
     * 保存
     *
     * @param ${domain}Vo
     */
    public void save(${Domain}Vo ${domain}Vo) {
        ${Domain} ${domain} = CopyUtil.copy(${domain}Vo, ${Domain}.class);
        if (StringUtil.isEmpty(${domain}.getId())) {
    <#list typeSet as type>
        <#if type=='Date'>
            Date now = new Date();
        </#if>
    </#list>
    <#list fieldList as field>
        <#if field.nameHump=='createdAt'>
            ${domain}.setCreatedAt(now);
        </#if>
        <#if field.nameHump=='updatedAt'>
            ${domain}.setUpdatedAt(now);
        </#if>
    </#list>
            ${domain}.setId(UuidUtil.getShortUuid());
            ${domain}Mapper.insert(${domain});
        } else {
    <#list fieldList as field>
        <#if field.nameHump=='updatedAt'>
            ${domain}.setUpdatedAt(new Date());
        </#if>
    </#list>
            ${domain}Mapper.updateByPrimaryKey(${domain});
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
