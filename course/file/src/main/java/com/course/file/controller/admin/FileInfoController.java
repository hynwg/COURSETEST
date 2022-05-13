package com.course.file.controller.admin;

import com.course.server.service.FileInfoService;
import com.course.server.vo.FileInfoVo;
import com.course.server.vo.PageVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.course.server.util.ValidatorUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/fileInfo")
public class FileInfoController {
    @Resource
    private FileInfoService fileInfoService;

    private static final Logger LOG = LoggerFactory.getLogger(FileInfoController.class);
    public static final String BUSINESS_NAME = "文件";

    @RequestMapping("/query")
    public ResponseVo query(@RequestBody PageVo pageVo) {
        LOG.info("pageVo:{}", pageVo);
        ResponseVo responseVo = new ResponseVo();
        fileInfoService.query(pageVo);
        responseVo.setContent(pageVo);
        return responseVo;
    }


    /**
     * 保存，id有值时更新，无值时新增
     *
     * @param fileInfoVo
     * @return
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody FileInfoVo fileInfoVo) {

        ResponseVo responseVo = new ResponseVo();
        fileInfoService.save(fileInfoVo);
        responseVo.setContent(fileInfoVo);
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
        fileInfoService.delete(id);
        return responseVo;
    }
}
