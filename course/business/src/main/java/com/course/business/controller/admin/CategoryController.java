package com.course.business.controller.admin;

import com.course.server.service.CategoryService;
import com.course.server.vo.CategoryPageVo;
import com.course.server.vo.CategoryVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    public static final String BUSINESS_NAME = "分类";
    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping("/all")
    public ResponseVo all() {
        ResponseVo responseVo = new ResponseVo();
        List<CategoryVo> categoryVoList = categoryService.all();
        responseVo.setContent(categoryVoList);
        return responseVo;
    }

    /**
     *分页查询
     * @param categoryPageVo
     * @return
     */
    @RequestMapping("/query")
    public ResponseVo query(@RequestBody CategoryPageVo categoryPageVo) {
        LOG.info("pageVo:{}", categoryPageVo);
        ResponseVo responseVo = new ResponseVo();
        categoryService.query(categoryPageVo);
        responseVo.setContent(categoryPageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param categoryVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody CategoryVo categoryVo) {

        ResponseVo responseVo = new ResponseVo();
        categoryService.save(categoryVo);
        responseVo.setContent(categoryVo);
        return responseVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable int id) {
        ResponseVo responseVo = new ResponseVo();
        categoryService.delete(id);
        return responseVo;
    }
}
