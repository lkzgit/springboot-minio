package springboot.minio.until;

import java.time.LocalDate;

public class TimeUtils {

    /**
     * 获取年月日：
     * @param nowTime
     * @param kind 00：年；01：月：02：日
     * @return
     */
    public static String getCode(LocalDate nowTime, String kind){
        String code = "";
        if ("00".equals(kind)) {
            code = String.valueOf(nowTime.getYear());
        } else if("01".equals(kind)) {
            code = String.valueOf(nowTime.getMonthValue());
        } else if ("02".equals(kind)) {
            code = String.valueOf(nowTime.getDayOfMonth());
        }
        return code;
    }

}
