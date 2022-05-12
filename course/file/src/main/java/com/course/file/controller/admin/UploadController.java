package com.course.file.controller.admin;

import com.course.server.util.UuidUtil;
import com.course.server.vo.FileVo;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RequestMapping("/admin/upload")
@RestController
public class UploadController {

    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    public static final String BUSINESS_NAME = "文件上传";

    @Value("${file.domain}")
    private String FILE_DOMAIN;

    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${vod.accessKeyId}")
    private String accessKeyId;

    @Value("${vod.accessKeySecret}")
    private String accessKeySecret;

//    @Resource
//    private FileService fileService;

    /**
     * 基本的文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public ResponseVo upload(@RequestParam MultipartFile file) throws Exception {
        LOG.info("上传文件开始:{}", file);
        LOG.info(file.getOriginalFilename());
        LOG.info(String.valueOf(file.getSize()));

        // 保存文件到本地
        String fileName = file.getOriginalFilename();
        String key = UuidUtil.getUuid();
        String fullPath = "D:/file/course/teacher/" + key + "-" + fileName;
        File dest = new File(fullPath);
        file.transferTo(dest);
        LOG.info(dest.getAbsolutePath());
        ResponseVo responseVo = new ResponseVo();
        return responseVo;
    }

//    @RequestMapping("/upload")
//    public ResponseVo upload(@RequestBody FileVo fileVo) throws Exception {
//        LOG.info("上传文件开始");
//        String use = fileVo.getUse();
//        String key = fileVo.getKey();
//        String suffix = fileVo.getSuffix();
//        String shardBase64 = fileVo.getShard();
//        MultipartFile shard = Base64ToMultipartFile.base64ToMultipart(shardBase64);
//
//        // 保存文件到本地
//        FileUseEnum useEnum = FileUseEnum.getByCode(use);
//
//        //如果文件夹不存在则创建
//        String dir = useEnum.name().toLowerCase();
//        File fullDir = new File(FILE_PATH + dir);
//        if (!fullDir.exists()) {
//            fullDir.mkdir();
//        }
//
////        String path = dir + File.separator + key + "." + suffix + "." + fileVo.getShardIndex();
//        String path = new StringBuffer(dir)
//                .append(File.separator)
//                .append(key)
//                .append(".")
//                .append(suffix)
//                .toString(); // course\6sfSqfOwzmik4A4icMYuUe.mp4
//        String localPath = new StringBuffer(path)
//                .append(".")
//                .append(fileVo.getShardIndex())
//                .toString(); // course\6sfSqfOwzmik4A4icMYuUe.mp4.1
//        String fullPath = FILE_PATH + localPath;
//        File dest = new File(fullPath);
//        shard.transferTo(dest);
//        LOG.info(dest.getAbsolutePath());
//
//        LOG.info("保存文件记录开始");
//        fileVo.setPath(path);
//        fileService.save(fileVo);
//
//        ResponseVo responseDto = new ResponseVo();
//        fileVo.setPath(FILE_DOMAIN + path);
//        responseDto.setContent(fileVo);
//
//        if (fileVo.getShardIndex().equals(fileVo.getShardTotal())) {
//            this.merge(fileVo);
//        }
//        return responseDto;
//    }

    public void merge(FileVo fileVo) throws Exception {
        LOG.info("合并分片开始");
        String path = fileVo.getPath(); //http://127.0.0.1:9000/file/f/course\6sfSqfOwzmik4A4icMYuUe.mp4
        path = path.replace(FILE_DOMAIN, ""); //course\6sfSqfOwzmik4A4icMYuUe.mp4
        Integer shardTotal = fileVo.getShardTotal();
        File newFile = new File(FILE_PATH + path);
        FileOutputStream outputStream = new FileOutputStream(newFile, true);//文件追加写入
        FileInputStream fileInputStream = null;//分片文件
        byte[] byt = new byte[10 * 1024 * 1024];
        int len;

        try {
            for (int i = 0; i < shardTotal; i++) {
                // 读取第i个分片
                fileInputStream = new FileInputStream(new File(FILE_PATH + path + "." + (i + 1))); //  course\6sfSqfOwzmik4A4icMYuUe.mp4.1
                while ((len = fileInputStream.read(byt)) != -1) {
                    outputStream.write(byt, 0, len);
                }
            }
        } catch (IOException e) {
            LOG.error("分片合并异常", e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                outputStream.close();
                LOG.info("IO流关闭");
            } catch (Exception e) {
                LOG.error("IO流关闭", e);
            }
        }
        LOG.info("合并分片结束");

        System.gc();
        Thread.sleep(100);

        // 删除分片
        LOG.info("删除分片开始");
        for (int i = 0; i < shardTotal; i++) {
            String filePath = FILE_PATH + path + "." + (i + 1);
            File file = new File(filePath);
            boolean result = file.delete();
            LOG.info("删除{}，{}", filePath, result ? "成功" : "失败");
        }
        LOG.info("删除分片结束");
    }

//    @GetMapping("/check/{key}")
//    public ResponseVo check(@PathVariable String key) throws Exception {
//        LOG.info("检查上传分片开始：{}", key);
//        ResponseVo responseDto = new ResponseVo();
//        FileVo fileVo = fileService.findByKey(key);
//        if (fileVo != null) {
//            if (StringUtils.isEmpty(fileVo.getVod())) {
//                fileVo.setPath(FILE_DOMAIN + fileVo.getPath());
//            } else {
//                DefaultAcsClient vodClient = VodUtil.initVodClient(accessKeyId, accessKeySecret);
//                GetMezzanineInfoResponse response = VodUtil.getMezzanineInfo(vodClient, fileVo.getVod());
//                System.out.println("获取视频信息, response : " + JSON.toJSONString(response));
//                String fileUrl = response.getMezzanine().getFileURL();
//                fileVo.setPath(fileUrl);
//            }
//        }
//        responseDto.setContent(fileVo);
//        return responseDto;
//    }
}
