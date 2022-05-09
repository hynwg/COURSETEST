package com.course.server.service;

import com.course.server.dao.AssetsInfoMapper;
import com.course.server.entity.AssetsInfo;
import com.course.server.entity.AssetsInfoExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.AssetsInfoVo;
import com.course.server.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssetsInfoService {
    @Resource
    private AssetsInfoMapper assetsInfoMapper;

    /**
     * 分页查询
     *
     * @param pageVo
     */
    public void query(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getSize());
        AssetsInfoExample assetsInfoExample = new AssetsInfoExample();
        List<AssetsInfo> assetsInfoList = assetsInfoMapper.selectByExample(assetsInfoExample);
        PageInfo<AssetsInfo> pageInfo = new PageInfo<>(assetsInfoList);
        pageVo.setTotal(pageInfo.getTotal());

        List<AssetsInfoVo> list = new ArrayList<>();
        for (int i = 0; i < assetsInfoList.size(); i++) {
            AssetsInfo assetsInfo = assetsInfoList.get(i);
            AssetsInfoVo assetsInfoVo = new AssetsInfoVo();
            BeanUtils.copyProperties(assetsInfo, assetsInfoVo);
            list.add(assetsInfoVo);
        }
        pageVo.setList(list);
    }

    /**
     * 保存
     *
     * @param assetsInfoVo
     */
    public void save(AssetsInfoVo assetsInfoVo) {
        AssetsInfo assetsInfo = CopyUtil.copy(assetsInfoVo, AssetsInfo.class);
        if (StringUtil.isEmpty(assetsInfo.getId())) {
            Date now = new Date();
            assetsInfo.setCreatedAt(now);
            assetsInfo.setUpdatedAt(now);
           // assetsInfo.setId(UuidUtil.getShortUuid());
            assetsInfoMapper.insert(assetsInfo);
        } else {
            assetsInfo.setUpdatedAt(new Date());
            assetsInfoMapper.updateByPrimaryKey(assetsInfo);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        assetsInfoMapper.deleteByPrimaryKey(id);
    }
}
