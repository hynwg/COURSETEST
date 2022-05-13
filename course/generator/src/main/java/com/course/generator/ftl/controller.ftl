package com.course.${module}.controller.admin;

import com.course.server.service.${Domain}Service;
import com.course.server.vo.${Domain}Vo;
import com.course.server.vo.PageVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.course.server.util.ValidatorUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {
    @Resource
    private ${Domain}Service ${domain}Service;

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "${tableNameCn}";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody PageVo pageVo) {
        LOG.info("pageVo:{}", pageVo);
        ResponseVo responseVo = new ResponseVo();
        ${domain}Service.query(pageVo);
        responseVo.setContent(pageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param ${domain}Vo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody ${Domain}Vo ${domain}Vo) {

        ResponseVo responseVo = new ResponseVo();
        ${domain}Service.save(${domain}Vo);
        responseVo.setContent(${domain}Vo);
        return responseVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable Integer id) {
        ResponseVo responseVo = new ResponseVo();
        ${domain}Service.delete(id);
        return responseVo;
    }
}
