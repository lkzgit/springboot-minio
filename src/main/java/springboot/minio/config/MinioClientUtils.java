package springboot.minio.config;

import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class MinioClientUtils {

//    private static MinioClient minioClient;
//
//    private static final Logger logger = LoggerFactory.getLogger(MinioClientUtils.class);
//
//    public static Boolean fileUpload(MultipartFile file, String filePath, String suffix, MinioConfig minioClientConfig) {
//        boolean flag = false;
//        // 先判断桶是否存在,如果不存在先创建桶
//        try {
//            if (!getMinioClient(minioClientConfig).bucketExists(suffix)) {
//                getMinioClient(minioClientConfig).makeBucket(suffix);
//            }
//            // 开始上传文件
//            InputStream inputStream = file.getInputStream();
//           getMinioClient(minioClientConfig).putObject(suffix,filePath,inputStream,inputStream.available(),file.getContentType());
//            flag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
//
//    public static MinioClient getMinioClient(MinioConfig clientConfig) {
//        if (minioClient == null) {
//            try {
//                minioClient = new MinioClient(clientConfig.getUrl(),clientConfig.getAccessKey(),clientConfig.getSecretKey());
//            } catch (Exception e) {
//                logger.info("creat minioClient fail");
//                e.printStackTrace();
//            }
//        }
//        return minioClient;
//    }
}
