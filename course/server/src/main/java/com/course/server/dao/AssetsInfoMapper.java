package com.course.server.dao;

import com.course.server.entity.AssetsInfo;
import com.course.server.entity.AssetsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsInfoMapper {
    long countByExample(AssetsInfoExample example);

    int deleteByExample(AssetsInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssetsInfo record);

    int insertSelective(AssetsInfo record);

    List<AssetsInfo> selectByExample(AssetsInfoExample example);

    AssetsInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssetsInfo record, @Param("example") AssetsInfoExample example);

    int updateByExample(@Param("record") AssetsInfo record, @Param("example") AssetsInfoExample example);

    int updateByPrimaryKeySelective(AssetsInfo record);

    int updateByPrimaryKey(AssetsInfo record);
}