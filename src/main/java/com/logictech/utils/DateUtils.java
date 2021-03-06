package com.logictech.utils;


import org.omg.CORBA.SystemException;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yl-zhang@logictech.cn
 * @version 1.0
 * @CreateOn 2016年12月28日 上午10:57:19
 * @Remark
 */
public class DateUtils {

    /**
     * 大于
     */
    public static final String COMPARE_TYPE_GT = "GT";
    /**
     * 大于等于
     */
    public static final String COMPARE_TYPE_GTE = "GTE";
    /**
     * 不等于
     */
    public static final String COMPARE_TYPE_NE = "NE";
    /**
     * 日期格式
     */
    public static String PATTEN_YMD = "yyyy-MM-dd";
    /**
     * 日期格式(中文)
     */
    public static String PATTEN_YMD_CHINESE = "yyyy年MM月dd日";
    /**
     * 日期格式2yyyy/MM/dd
     */
    public static String PATTEN_YMD2 = "yyyy/MM/dd";
    /**
     * 日期格式
     */
    public static String PATTEN_YMTOW = "yyyy-MM";
    /**
     * 日期时间 格式
     */
    public static String PATTEN_HMS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期时间 格式
     */
    public static String PATTEN_HM = "yyyy/MM/dd HH:mm";
    /**
     * 带毫秒日期格式
     */
    public static String PATTEN_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 日期格式,不带分隔符
     */
    public static String PATTEN_YMD_NO_SEPRATE = "yyyyMMdd";
    /**
     * 文件重命名专用日期格式
     */
    public static String PATTEN_FILE_RENAME = "yyyyMMddHHmmssSSS";
    /**
     * 日期格式
     */
    public static String PATTEN_YMDH = "yyyy-MM-dd HH";
    public static String PATTEN_YM = "yyyyMM";
    public static String PATTEN_Y = "yyyy";
    /**
     * 日期验证复杂正则
     */
    public static String DATE_REG = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-9])))";

    /**
     * 时间日期的正则表达式，可以匹配yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_TIME_REGEXP = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)\\s+([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
    /**
     * 可以匹配yyyy-MM-dd
     */
    public static final String DATE_REGEXP = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)?$";
    /**
     * 默认的日期间隔符
     */
    public static String DEFAULT_SEPERATOR = "-";
    /**
     * 日期验证简单正则 YYYY-MM-DD
     */
    private static String DATE_REG_SIMPLE = "^\\d{4}-\\d{2}-\\d{2}$";

    /**
     * 提供日期格式化工具
     *
     * @param pattern 日期格式
     * @return 格式化工具类
     */
    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 将当前时间转换成指定的格式显示
     *
     * @param pattern 日期格式
     * @return 转换后的日期字符串
     */
    public static String dateToString(String pattern) {
        return getDateParser(pattern).format(new Date());
    }

    /**
     * 将指定日期转换成指定格式的字符串
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 转换后的日期字符串
     */
    public static String dateToString(Date date, String pattern) {
        return getDateParser(pattern).format(date);
    }

    /**
     * 将指定格式的时间转换成Date类型
     *
     * @param date    指定日期
     * @param pattern 格式
     * @return 转换后日期
     * @throws SystemException 转换异常时，返回系统异常
     */
    public static Date stringToDate(String date, String pattern) throws SystemException {
        if (StringUtils.isEmpty(pattern)) {
            pattern = PATTEN_YMD;
        }
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        Date result = null;
        try {
            result = getDateParser(pattern).parse(date);
        } catch (ParseException e) {
//            throw new SystemException();
        }
        return result;
    }

    /**
     * 将指定格式的时间转换成其他日期格式
     *
     * @param date          指定日期
     * @param pattern       指定格式
     * @param resultPattern 目标格式
     * @return 转换后的日期字符串
     * @throws SystemException 转换异常，抛出系统异常
     */
    public static String changeDateFormat(String date, String pattern, String resultPattern) throws SystemException {
        String result = "";
        try {
            Date dateTmp = null;
            dateTmp = getDateParser(pattern).parse(date);
            result = getDateParser(resultPattern).format(dateTmp);
        } catch (ParseException e) {
//            throw new ParseException();
        }
        return result;
    }

    /**
     * 获取前一天日期
     *
     * @param fm 日期格式
     * @return 前一天 日期
     * @throws SystemException 转换异常，抛出系统异常
     */
    public static String stringToBeforeDate(String fm) throws SystemException {
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -1);
        Format format = new SimpleDateFormat(fm);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 获取当前日期前30天的日期
     *
     * @param fm 日期格式
     * @return 当前日期前三十天的日期
     * @throws SystemException 转换异常，抛出系统异常
     */
    public static String thirtyDaysBeforeNow(String fm) throws SystemException {
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -30);
        Format format = new SimpleDateFormat(fm);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 获取指定日期的前30天的日期
     *
     * @param startDate 指定日期
     * @param fm        格式
     * @return 指定日期前30天的日期
     * @throws SystemException 转换异常，抛出系统异常
     */
    public static String thirtyDaysBeforeSpecifiedDate(Date startDate, String fm) throws SystemException {
        String result;
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.add(Calendar.DAY_OF_MONTH, -30);
        Format format = new SimpleDateFormat(fm);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 获取当天日期
     *
     * @param fm 日期格式
     * @return 当天日期
     * @throws SystemException 转换异常，抛出系统异常
     */
    public static String stringToToday(String fm) throws SystemException {
        String result;
        Format format = new SimpleDateFormat(fm);
        result = format.format(new Date());
        return result;
    }

    /**
     * 返回某月的第一天
     *
     * @param year  年
     * @param month 月
     * @return 某月的第一天
     */
    public static Date getFirstDayOfMonth(String year, String month) {
        //验证空
        if (StringUtils.isEmpty(year) || StringUtils.isEmpty(month)) {
            return null;
        }
        //验证年
        if (!StringUtils.matches(year, "\\d{4}")) {
            return null;
        }
        //验证月
        int monthValue = Integer.parseInt(month);
        if (monthValue > 12 || monthValue < 1) {
            return null;
        }
        //改成  yyyy-MM-dd格式
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append(DEFAULT_SEPERATOR);
        sb.append(month);
        sb.append(DEFAULT_SEPERATOR);
        sb.append("01");
        return stringToDate(sb.toString(), PATTEN_YMD);
    }

    /**
     * 返回某月的最后一天
     *
     * @param year  年
     * @param month 月
     * @return 某月的最后一天
     */
    public static Date getLastDayOfMonth(String year, String month) {
        //验证空
        if (StringUtils.isEmpty(year) || StringUtils.isEmpty(month)) {
            return null;
        }
        //验证年
        if (!StringUtils.matches(year, "\\d{4}")) {
            return null;
        }
        //验证月
        int monthValue = Integer.parseInt(month);
        if (monthValue > 12 || monthValue < 1) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, monthValue - 1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 返回yyyy-mm-dd格式日期
     *
     * @param date 传入的日期
     * @return yyyy-mm-dd格式日期
     */
    public static String formatString(String date) {

        if (StringUtils.isEmpty(date) || !checkIsActiveDate(date)) {
            return "";
        }
        if (date.length() < 10) {
            return date;
        } else {
            return date.substring(0, 10);
        }
    }

    /**
     * 返回指定格式的日期字符串
     *
     * @param date   待转化的日期数据
     * @param dateFm 日期格式
     * @return 指定格式的日期字符串
     */
    public static String formatString(Date date, String dateFm) {
        if (StringUtils.isEmpty(dateFm)) {
            dateFm = PATTEN_YMD;
        }
        if (null == date) {
            return "";
        }
        Format fm = new SimpleDateFormat(dateFm);
        return fm.format(date);
    }

    /**
     * 获取当前日期字符串
     *
     * @param formart 日期格式
     * @return 当前日期字符串
     */
    public static String getDateFormatStr(String formart) {
        return new SimpleDateFormat(formart).format(new Date());
    }

    /**
     * 日期加年
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 增加X年后的日期
     */
    public static Date addYear(Date date, int spans) {
        return addDate(date, Calendar.YEAR, spans);
    }

    /**
     * 日期加月
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 加月后的日期
     */
    public static Date addMonth(Date date, int spans) {
        return addDate(date, Calendar.MONTH, spans);
    }

    /**
     * 日期加天
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 加天后的日期
     */
    public static Date addDay(Date date, int spans) {
        return addDate(date, Calendar.DAY_OF_MONTH, spans);
    }

    /**
     * 日期加小时
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 加小时后的日期
     */
    public static Date addHour(Date date, int spans) {
        return addDate(date, Calendar.HOUR_OF_DAY, spans);
    }

    /**
     * 日期加分钟
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 加分钟后的日期
     */
    public static Date addMinute(Date date, int spans) {
        return addDate(date, Calendar.MINUTE, spans);
    }

    /**
     * 日期加秒
     *
     * @param date  日期
     * @param spans 增加数量
     * @return 加秒后的日期
     */
    public static Date addSecond(Date date, int spans) {
        return addDate(date, Calendar.SECOND, spans);
    }

    /**
     * 日期加法计算
     *
     * @param date  日期
     * @param type  增加类型
     * @param spans 增加数量
     * @return 加法计算后的日期
     */
    public static Date addDate(Date date, int type, int spans) {
        Calendar inputCalendar = Calendar.getInstance();
        inputCalendar.setTime(date);
        inputCalendar.add(type, spans);
        return inputCalendar.getTime();
    }

    /**
     * 获取当前day of month
     *
     * @return String
     */
    public static String getCurrentDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 获取当前月份数字
     *
     * @return String
     */
    public static String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取当前小时
     *
     * @return String
     */
    public static String getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
    }

    /**
     * 获取当前年
     *
     * @return String
     */
    public static String getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    /**
     * 获取当前时间，字符串类型，格式（yyyy-mm-dd）
     *
     * @return String
     */
    public static String getCurrentDateString() {
        return getDateFormatStr(PATTEN_YMD);
    }

    /**
     * 获取当前时间，字符串类型，格式（yyyy-mm-dd HH:MM:SS）
     *
     * @return String
     */
    public static String getCurrentDate2String() {
        return getDateFormatStr(PATTEN_HMS);
    }

    /**
     * 获取当前时间， 日期类型
     *
     * @return java.util.Date
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 判断是否是有效日期
     *
     * @param date 判断日期
     * @return 是否有效日期
     */
    public static boolean checkIsActiveDate(String date) {
        //先验证基本格式是否正确
        if (!StringUtils.matches(date, DATE_REG_SIMPLE)) {
            return false;
        }
        //验证复杂格式是否正确
        if (StringUtils.isNotEmpty(date) && date.contains(DEFAULT_SEPERATOR)) {
            String dateNoSeprator = date.replaceAll(DEFAULT_SEPERATOR, "");
            return StringUtils.matches(dateNoSeprator, DATE_REG);
        }
        return false;
    }

    /**
     * 日期比较， 后面日期比前面的日期大
     *
     * @param dateFrom 开始日期
     * @param dateEnd  结束日期
     * @return boolean 比较结果
     */
    public static boolean checkDateFromTo(String dateFrom, String dateEnd) {
        return checkDateCompare(dateFrom, dateEnd, DateUtils.COMPARE_TYPE_GTE);
    }

    /**
     * 判断前后日期对比。 如果后面的日期大于前面的日期， 返回true。 否则返回false。
     *
     * @param dateFromStr 开始日期
     * @param dateEndStr  结束日期
     * @return boolean 比较结果
     */
    private static boolean checkDateCompare(String dateFromStr, String dateEndStr, String compareType) {
        if (!checkIsActiveDate(dateFromStr) || !checkIsActiveDate(dateEndStr)) {
            return false;
        } else {
            Date dateFrom = DateUtils.stringToDate(dateFromStr, DateUtils.PATTEN_YMD);
            Date dateEnd = DateUtils.stringToDate(dateEndStr, DateUtils.PATTEN_YMD);

            if (COMPARE_TYPE_GT.equals(compareType)) {
                //大于
                if (dateFrom.before(dateEnd)) {
                    return true;
                }
            } else if (COMPARE_TYPE_GTE.equals(compareType)) {
                //大于等于
                if (!dateEnd.before(dateFrom)) {
                    return true;
                }
            } else if (COMPARE_TYPE_GTE.equals(compareType)) {
                //不等于
                if (!StringUtils.isEqual(dateFromStr, dateEndStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 比较两个日期大小
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 开始日期早于结束日期，返回true。否则返回false。相等，返回false
     */
    public static boolean dateCompare(Date startDate, Date endDate) {
        return startDate.before(endDate);
    }

    /**
     * 比较两个日期大小
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 开始日期早于结束日期，返回true。否则返回false。相等，返回true
     */
    public static boolean dateCompare1(Date startDate, Date endDate) {
        return startDate.before(endDate) || startDate.compareTo(endDate) == 0;
    }

    /**
     * 返回指定日期的年
     *
     * @param date 指定的日期
     * @return 指定日期的年
     */
    public static String getYearFromDate(String date) {
        if (!checkIsActiveDate(date)) {
            return "";
        }
        //日期格式化
        try {
            Date dateTmp = getDateParser(PATTEN_YMD).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTmp);
            return String.valueOf(calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 返回指定日期的月
     *
     * @param date 指定的日期
     * @return 指定日期的月
     */
    public static String getMonthFromDate(String date) {
        if (!checkIsActiveDate(date)) {
            return "";
        }
        //日期格式化
        try {
            Date dateTmp = getDateParser(PATTEN_YMD).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTmp);
            return String.valueOf(calendar.get(Calendar.MONTH) + 1);
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 返回指定日期的日
     *
     * @param date 指定日期
     * @return 指定日期的日
     */
    public static String getDayFromDate(String date) {
        if (!checkIsActiveDate(date)) {
            return "";
        }
        //日期格式化
        try {
            Date dateTmp = getDateParser(PATTEN_YMD).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTmp);
            return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 根据日期取得星期几
     *
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 返回指定日期的月份的最大天数
     *
     * @param date 指定日期
     * @return 指定月份的最大天数
     */
    public static String getMaxDayFromDate(String date) {
        if (!checkIsActiveDate(date)) {
            return "";
        }
        //日期格式化
        try {
            Date dateTmp = getDateParser(PATTEN_YMD).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTmp);
            return String.valueOf(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 字符串的日期格式的计算
     *
     * @param smdate 指定开始日期
     * @param bdate  指定结束日期
     * @return 相差天数
     * @throws ParseException
     */
    public static Integer daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }
   
    /** 
     * 比较 指定年月 与 当前时间 相差几月 
     * @param year 年 
     * @param month 月 
     * @return 
     * @return 相差几月
     */  
    public static int monthBetween(int year, int month) {  
        // YearMonth yearMonth = YearMonth.of(year, month);
        // 当前年月
        // YearMonth yearMonthNow = YearMonth.now();
        // return yearMonthNow.compareTo(yearMonth);
        return (YearMonth.now().getYear() - year ) *12 + YearMonth.now().getMonthValue() - month;
    }

    /**
     * token过期时间 1小时
     *
     * @return token过期时间
     */
    public static Date getTokenExpired() {
        return new Date(System.currentTimeMillis() + 60 * 60 * 1 * 1000);
    }
}
