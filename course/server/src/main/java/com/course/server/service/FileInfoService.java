package com.course.server.service;

import com.course.server.dao.FileInfoMapper;
import com.course.server.entity.FileInfo;
import com.course.server.entity.FileInfoExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.FileInfoVo;
import com.course.server.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FileInfoService {
    @Resource
    private FileInfoMapper fileInfoMapper;

    /**
     * 分页查询
     *
     * @param pageVo
     */
    public void query(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getSize());
        FileInfoExample fileInfoExample = new FileInfoExample();
        List<FileInfo> fileInfoList = fileInfoMapper.selectByExample(fileInfoExample);
        PageInfo<FileInfo> pageInfo = new PageInfo<>(fileInfoList);
        pageVo.setTotal(pageInfo.getTotal());
        List<FileInfoVo> fileInfoVoList = CopyUtil.copyList(fileInfoList, FileInfoVo.class);
        pageVo.setList(fileInfoVoList);
    }

    /**
     * 保存
     *
     * @param fileInfoVo
     */
    public void save(FileInfoVo fileInfoVo) {
        FileInfo fileInfo = CopyUtil.copy(fileInfoVo, FileInfo.class);
        if (fileInfo.getId() == null) {
            Date now = new Date();
            fileInfo.setCreatedAt(now);
            fileInfo.setUpdatedAt(now);

            fileInfoMapper.insert(fileInfo);
        } else {
            fileInfo.setUpdatedAt(new Date());
            fileInfoMapper.updateByPrimaryKey(fileInfo);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id) {
        fileInfoMapper.deleteByPrimaryKey(id);
    }
}
