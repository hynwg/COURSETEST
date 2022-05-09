package com.course.server.service;

import com.course.server.dao.CategoryMapper;
import com.course.server.entity.Category;
import com.course.server.entity.CategoryExample;
import com.course.server.util.CopyUtil;
import com.course.server.vo.CategoryPageVo;
import com.course.server.vo.CategoryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 分页查询
     *
     * @param categoryPageVo
     */
    public void query(CategoryPageVo categoryPageVo) {
        PageHelper.startPage(categoryPageVo.getPage(), categoryPageVo.getSize());
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        categoryPageVo.setTotal(pageInfo.getTotal());
    List<CategoryVo> categoryVoList = CopyUtil.copyList(categoryList,CategoryVo.class);
        categoryPageVo.setList(categoryVoList);
    }

    /**
     * 保存
     *
     * @param categoryVo
     */
    public void save(CategoryVo categoryVo) {
        Category category = CopyUtil.copy(categoryVo, Category.class);
        if (category.getId()==null) {
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
