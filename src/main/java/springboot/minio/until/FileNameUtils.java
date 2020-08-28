package springboot.minio.until;

import java.time.LocalDate;

/**
 * lkz
 * 该工具类生成文件在服务器上的唯一的文件名
 * 可自行更改,推荐使用雪花算法
 */
public class FileNameUtils {

    public static String getNextId (String prefix) {
        String fileName = "";
        // 生成6位数随机数
        String random = String.valueOf((int) ((Math.random()*9+1)*100000));
        fileName = new StringBuilder().append(prefix).append(LocalDate.now()).append(random).toString();
        return fileName;
    }


    public static void main(String[] args) {
        String nextId = FileNameUtils.getNextId("随访");
        System.out.println(nextId);
    }
}
