package com.course.business.controller.admin;

import com.course.server.service.AssetsInfoService;
import com.course.server.vo.AssetsInfoVo;
import com.course.server.vo.PageVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/assetsInfo")
public class AssetsInfoController {
    @Resource
    private AssetsInfoService assetsInfoService;

    private static final Logger LOG = LoggerFactory.getLogger(AssetsInfoController.class);
    public static final String BUSINESS_NAME = "资产信息";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody PageVo pageVo) {
        LOG.info("pageVo:{}", pageVo);
        ResponseVo responseVo = new ResponseVo();
        assetsInfoService.query(pageVo);
        responseVo.setContent(pageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param assetsInfoVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody AssetsInfoVo assetsInfoVo) {

        ResponseVo responseVo = new ResponseVo();
        assetsInfoService.save(assetsInfoVo);
        responseVo.setContent(assetsInfoVo);
        return responseVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVo delete(@PathVariable String id) {
        ResponseVo responseVo = new ResponseVo();
        assetsInfoService.delete(id);
        return responseVo;
    }
}
