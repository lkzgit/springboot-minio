package springboot.minio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.minio.config.MinioClientUtils;
import springboot.minio.config.MinioConfig;
import springboot.minio.config.MinioUtils;
import springboot.minio.until.FileNameUtils;
import springboot.minio.until.TimeUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.time.LocalDate;


@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    MinioConfig minIoProperties;

    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        // 文件名
        String fileName = "";
        // 文件格式
        String prefix = "";
        // 服务器上文件的相对路径
        String filePath = "";
        // 上传成功标识
        boolean flag = false;
        // 获取文件前缀
        int index= file.getOriginalFilename().indexOf(".")+1;
        prefix = file.getOriginalFilename().substring(index);
        fileName = FileNameUtils.getNextId(prefix);
        final InputStream is = file.getInputStream();
        String fileUrl = MinioUtils.upload(minIoProperties.getBocket(),fileName, is);
        return "文件下载地址：" + fileUrl;
    }

    /**
     * 下载文件
     * @param fileName
     * @param response
     */
    @GetMapping(value = "/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        MinioUtils.download(minIoProperties.getBocket(), fileName, response);
    }

    /**
     * 删除文件
     * @param fileName
     * @return
     */

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("fileName") String fileName) {
        MinioUtils.deleteFile(minIoProperties.getBocket(), fileName);
        return "删除成功";
    }




//    /**
//     * 单文件上传
//     * @param file
//     * @return 返回文件名，让业务方做记录
//     */
//    @PostMapping("/uploadFile")
//    public String fileUploa(@RequestParam MultipartFile file) {
//        // 文件名
//        String fileName = "";
//        // 文件格式
//        String prefix = "";
//        // 服务器上文件的相对路径
//        String filePath = "";
//        // 上传成功标识
//        boolean flag = false;
//        // 获取文件前缀
//        int index= file.getOriginalFilename().indexOf(".")+1;
//        prefix = file.getOriginalFilename().substring(index);
//        fileName = FileNameUtils.getNextId(prefix);
//        // 文件相对路径我这边设置成了/桶名/年/月/日/唯一文件名
//        LocalDate localDate = LocalDate.now();
//        filePath =  new StringBuilder()
//                .append("/").append(TimeUtils.getCode(localDate,"00"))
//                .append("/").append(TimeUtils.getCode(localDate,"01"))
//                .append("/").append(TimeUtils.getCode(localDate,"02"))
//                .append("/").append(fileName).append(".").append(prefix).toString();
//        flag = MinioClientUtils.fileUpload(file,filePath,prefix,minIoProperties);
//        if (flag){
//            return fileName;
//        } else {
//            return null;
//        }
//    }


}
