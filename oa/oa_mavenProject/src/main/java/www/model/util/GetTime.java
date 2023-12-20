package www.model.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 提供获取时间
public class GetTime {
    public static final String DEFAULT_DATETIME_FORMAT="yyyy年MM月dd日 HH:mm:ss";
    public static final String DATETIME_FORMAT1="yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT2="yyyy/MM/dd HH:mm:ss";
    public static final String DATETIME_FORMAT3="yyyyMMddHHmmss";
    public static final String DATETIME_FORMAT4="yyMMddHHmmss";
    public static final String DATETIME_FORMAT5="yyyyMMddHHmmssSSS";
    public static final String DATE_FORMAT1="yyyy-MM-dd";
    public static final String DATE_FORMAT2="yyyy/MM/dd";
    public static final String DATE_FORMAT3="yyyy年MM月dd日";
    public static String nowTime(String pattern ){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String str  = localDateTime.format(dateTimeFormatter);
        return str;
    }

    public static void main(String[] args) {
        String p = "yyyy年MM月dd日 HH:mm:ss";
        System.out.println(nowTime(DATETIME_FORMAT5));
    }
}
