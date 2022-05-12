package com.course.file.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class OssController {
//
//    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
//
//    @Value("${oss.accessKeyId}")
//    private String accessKeyId;
//
//    @Value("${oss.accessKeySecret}")
//    private String accessKeySecret;
//
//    @Value("${oss.endpoint}")
//    private String endpoint;
//
//    @Value("${oss.bucket}")
//    private String bucket;
//
//    @Value("${oss.domain}")
//    private String ossDomain;
//
//    public static final String BUSINESS_NAME = "文件上传";
//
//    @Resource
//    private FileService fileService;
//
//    @PostMapping("/oss-append")
//    public ResponseVo fileUpload(@RequestBody FileVo fileVo) throws Exception {
//        LOG.info("上传文件开始");
//        String use = fileVo.getUse();
//        String key = fileVo.getKey();
//        String suffix = fileVo.getSuffix();
//        Integer shardIndex = fileVo.getShardIndex();
//        Integer shardSize = fileVo.getShardSize();
//        String shardBase64 = fileVo.getShard();
//        MultipartFile shard = Base64ToMultipartFile.base64ToMultipart(shardBase64);
//
//        // 保存文件到本地
//        FileUseEnum useEnum = FileUseEnum.getByCode(use);
//
////        //如果文件夹不存在则创建
//        String dir = useEnum.name().toLowerCase();
////        File fullDir = new File(FILE_PATH + dir);
////        if (!fullDir.exists()) {
////            fullDir.mkdir();
////        }
//
////        String path = dir + File.separator + key + "." + suffix + "." + fileVo.getShardIndex();
//        String path = new StringBuffer(dir)
//                .append("/")
//                .append(key)
//                .append(".")
//                .append(suffix)
//                .toString(); // course\6sfSqfOwzmik4A4icMYuUe.mp4
////        String localPath = new StringBuffer(path)
////                .append(".")
////                .append(fileVo.getShardIndex())
////                .toString(); // course\6sfSqfOwzmik4A4icMYuUe.mp4.1
////        String fullPath = FILE_PATH + localPath;
////        File dest = new File(fullPath);
////        shard.transferTo(dest);
////        LOG.info(dest.getAbsolutePath());
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        ObjectMetadata meta = new ObjectMetadata();
//// 指定上传的内容类型。
//        meta.setContentType("text/plain");
//
//        // 通过AppendObjectRequest设置多个参数。
//        AppendObjectRequest appendObjectRequest = new AppendObjectRequest(bucket, path, new ByteArrayInputStream(shard.getBytes()),meta);
//
//        // 通过AppendObjectRequest设置单个参数。
//        // 设置存储空间名称。
//        //appendObjectRequest.setBucketName("<yourBucketName>");
//        // 设置文件名称。
//        //appendObjectRequest.setKey("<yourObjectName>");
//        // 设置待追加的内容。有两种可选类型：InputStream类型和File类型。这里为InputStream类型。
//        //appendObjectRequest.setInputStream(new ByteArrayInputStream(content1.getBytes()));
//        // 设置待追加的内容。有两种可选类型：InputStream类型和File类型。这里为File类型。
//        //appendObjectRequest.setFile(new File("<yourLocalFile>"));
//        // 指定文件的元信息，第一次追加时有效。
//        //appendObjectRequest.setMetadata(meta);
//
//        // 第一次追加。
//        // 设置文件的追加位置。
////        appendObjectRequest.setPosition(0L);
//        appendObjectRequest.setPosition((long) ((shardIndex - 1) * shardSize));
//        AppendObjectResult appendObjectResult = ossClient.appendObject(appendObjectRequest);
//        // 文件的64位CRC值。此值根据ECMA-182标准计算得出。
//        System.out.println(appendObjectResult.getObjectCRC());
//        System.out.println(JSONObject.toJSONString(appendObjectResult));
//
////        // 第二次追加。
////        // nextPosition指明下一次请求中应当提供的Position，即文件当前的长度。
////        appendObjectRequest.setPosition(appendObjectResult.getNextPosition());
////        appendObjectRequest.setInputStream(new ByteArrayInputStream(content2.getBytes()));
////        appendObjectResult = ossClient.appendObject(appendObjectRequest);
////
////        // 第三次追加。
////        appendObjectRequest.setPosition(appendObjectResult.getNextPosition());
////        appendObjectRequest.setInputStream(new ByteArrayInputStream(content3.getBytes()));
////        appendObjectResult = ossClient.appendObject(appendObjectRequest);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//
//        LOG.info("保存文件记录开始");
//        fileVo.setPath(path);
//        fileService.save(fileVo);
//
//        ResponseVo responseVo = new ResponseVo();
//        fileVo.setPath(ossDomain + path);
//        responseVo.setContent(fileVo);
//
////        if (fileVo.getShardIndex().equals(fileVo.getShardTotal())) {
////            this.merge(fileVo);
////        }
//        return responseVo;
//    }
//
//
//
//    @PostMapping("/oss-simple")
//    public ResponseVo fileUpload(@RequestParam MultipartFile file, String use) throws Exception {
//        LOG.info("上传文件开始");
//        FileUseEnum useEnum = FileUseEnum.getByCode(use);
//        String key = UuidUtil.getShortUuid();
//        String fileName = file.getOriginalFilename();
//        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//        String dir = useEnum.name().toLowerCase();
//        String path = dir + "/" + key + "." + suffix;
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 创建PutObjectRequest对象。
////        String content = "Hello OSS";
//        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, path, new ByteArrayInputStream(file.getBytes()));
//
//        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
//        // ObjectMetadata metadata = new ObjectMetadata();
//        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//        // metadata.setObjectAcl(CannedAccessControlList.Private);
//        // putObjectRequest.setMetadata(metadata);
//
//        // 上传字符串。
//        ossClient.putObject(putObjectRequest);
//
////        LOG.info("保存文件记录开始");
////        fileVo.setPath(path);
////        fileService.save(fileVo);
//
//        ResponseVo responseVo = new ResponseVo();
//        FileVo fileVo = new FileVo();
//        fileVo.setPath(ossDomain + path);
//        responseVo.setContent(fileVo);
//
//        return responseVo;
//    }
}
