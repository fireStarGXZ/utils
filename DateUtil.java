package com.yicall.screen.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author gxz
 * @Date 2022/11/14 13:14
 */
public class DateUtil {
    public static final String[] months = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};

    public static final String[] quarters = {"一季度", "二季度", "三季度", "四季度"};

    public DateUtil() {
    }

    /**
     * 获取当前日期和时间
     * 格式 yyyyMMdd HH:mm:ss
     *
     * @return String
     */
    public static String getCurrentDateStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    /**
     * 获取日期字符串。
     * <p>
     * <pre>
     *  日期字符串格式： yyyyMMdd
     *  其中：
     *      yyyy   表示4位年。
     *      MM     表示2位月。
     *      dd     表示2位日。
     * </pre>
     *
     * @return String "yyyyMMdd"格式的日期字符串。
     */
    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        return formatter.format(new Date());
    }

    /**
     * 获取当前年度字符串。
     * <p>
     * <pre>
     *  日期字符串格式： yyyy
     *  其中：
     *      yyyy   表示4位年。
     * </pre>
     *
     * @return String "yyyy"格式的当前年度字符串。
     */
    public static String getNowYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

        return formatter.format(new Date());
    }

    /**
     * 获取当前月度字符串。
     * <p>
     * <pre>
     *  日期字符串格式： MM
     *  其中：
     *      MM   表示4位年。
     * </pre>
     *
     * @return String "yyyy"格式的当前月度字符串。
     */
    public static String getNowMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        return formatter.format(new Date());
    }

    /**
     * 获取当前月度字符串。
     * <p>
     * <pre>
     *  日期字符串格式： dd
     *  其中：
     *      dd   表示4位年。
     * </pre>
     *
     * @return String "yyyy"格式的当前月度字符串。
     */
    public static String getNowDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");

        return formatter.format(new Date());
    }

    /**
     * 获取日期字符串。
     * <p>
     * <pre>
     *  日期字符串格式： yyyyMMdd
     *  其中：
     *      yyyy   表示4位年。
     *      MM     表示2位月。
     *      dd     表示2位日。
     * </pre>
     *
     * @param date 需要转化的日期。
     * @return String "yyyyMMdd"格式的日期字符串。
     */
    public static String getDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        return formatter.format(date);
    }

    public static String getDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }

    /**
     * 获取日期字符串。
     *
     * <pre>
     *  日期字符串格式： yyyyMMdd
     *  其中：
     *      yyyy   表示4位年。
     *      MM     表示2位月。
     *      dd     表示2位日。
     * </pre>
     *
     * @param date
     *                需要转化的日期。
     * @return String "yyyyMMdd"格式的日期字符串。
     */
    /**
     * 将指定的日期字符串转化为日期对象
     *
     * @param dateStr 日期字符串
     * @return java.util.Date
     * @roseuid 3F39FE450385
     */
    public static Date getDate(String dateStr) {
        if (DateUtil.isDate(dateStr)) { // 日期型
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            try {
                java.util.Date date = df.parse(dateStr);
                return date;
            } catch (Exception ex) {
                return null;
            } // end try - catch
        } else if (DateUtil.isDateTime(dateStr)) { // 日期时间型
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                java.util.Date date = df.parse(dateStr);
                return date;
            } catch (Exception ex) {
                return null;
            } // end try - catch
        } // end if
        return null;
    }

    public static Date getDate(String dateStr, String pattern) {
        if (DateUtil.isDateTime(dateStr, pattern)) { // 日期型
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {
                java.util.Date date = df.parse(dateStr);
                return date;
            } catch (Exception ex) {
                return null;
            } // end try - catch
        }
        return null;
    }

    /**
     * 获取日期字符串。
     * <p>
     * <pre>
     *  日期字符串格式： yyyy-MM-dd
     *  其中：
     *      yyyy   表示4位年。
     *      MM     表示2位月。
     *      dd     表示2位日。
     * </pre>
     *
     * @return String "yyyy-MM-dd"格式的日期字符串。
     */
    public static String getHyphenDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(new Date());
    }

    /**
     * 获取日期字符串。
     * <p>
     * <pre>
     *  日期字符串格式： yyyy-MM-dd
     *  其中：
     *      yyyy   表示4位年。
     *      MM     表示2位月。
     *      dd     表示2位日。
     * </pre>
     *
     * @param date 需要转化的日期。
     * @return String "yyyy-MM-dd"格式的日期字符串。
     */
    public static String getHyphenDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }

    /**
     * 将"yyyyMMdd"格式的日期字符串转换为日期对象。
     *
     * @param source 日期字符串。
     * @return Date 日期对象。
     */
    public static Date parsePlainDate(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        return sdf.parse(source, new ParsePosition(0));
    }

    /**
     * 将“yyyy-MM-dd”格式的日期字符串转换为日期对象。
     *
     * @param source 日期字符串。
     * @return Date 日期对象。
     */
    public static Date parseHyphenDate(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.parse(source, new ParsePosition(0));
    }

    /**
     * 将指定格式的日期字符串转换为日期对象。
     *
     * @param source  日期字符串。
     * @param pattern 模式。
     * @return Date 日期对象。
     */
    public static Date parseDate(String source, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.parse(source, new ParsePosition(0));
    }

    /**
     * 将“yyyy-MM-dd”格式的日期字符串转换为“yyyyMMdd”格式的日期字符串。
     *
     * @param source 日期字符串。
     * @return String "yyyymmdd"格式的日期字符串。
     */
    public static String toPlainDate(String source) {
        Date date = parseHyphenDate(source);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        return formatter.format(date);
    }

    /**
     * 将“yyyyMMdd”格式的日期字符串转换为“yyyy-MM-dd”格式的日期字符串。
     *
     * @param source 日期字符串。
     * @return String "yyyy-MM-dd"格式的日期字符串。
     */
    public static String toHyphenDate(String source) {
        Date date = parsePlainDate(source);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }

    /**
     * 获取时间戳，将日期对象转换为时间戳类型。
     *
     * @param date 日期对象
     * @return Timestamp 时间戳
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取时间戳，将当前日期转换为时间戳类型。
     *
     * @return Timestamp 时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 将“yyyyMMdd”格式的日期字符串转换为Timestamp类型的对象。
     *
     * @param source 日期字符串
     * @return Timestamp 时间戳
     */
    public static Timestamp parseTimestamp(String source) {
        Date date = parsePlainDate(source);

        return getTimestamp(date);
    }

    /**
     * 获得年度周期 <br>
     * Example:<br>
     * XJPDateUtil.getPeriodYear("20040229" , -1);<br>
     * XJPDateUtil.getPeriodYear("20040228" , -1);<br>
     * XJPDateUtil.getPeriodYear("20020230" , 2);<br>
     *
     * @param source     时间串
     * @param yearPeriod 年度周期 -1代表本时间的上一年度,以次类推。
     * @return String 时间。
     */
    public static String getPeriodYear(String source, int yearPeriod) {
        int p = Integer.parseInt(source.substring(0, 4)) + yearPeriod;
        String newYear = String.valueOf(p) + source.substring(4, source.length());
        Date date = parsePlainDate(newYear);
        String s = getDate(date);
        int ny = Integer.parseInt(s);
        int sy = Integer.parseInt(newYear);

        while (ny > sy) {
            sy--;
            ny = Integer.parseInt(getDate(parsePlainDate(String.valueOf(sy))));
        }

        return String.valueOf(sy);
    }

    /**
     * 当前日期延后多少天
     *
     * @param day 天数
     * @return 返回相加后的日期
     */
    public static String addDate(int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTimeInMillis(System.currentTimeMillis() + ((long) day) * 24 * 3600 * 1000);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return df.format(c.getTime());
    }

    /**
     * 日期减上多少月前的日期
     *
     * @param now
     * @param month
     * @return
     */
    public static Date dateReduceMonth(Date now, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, month * -1);
        return calendar.getTime();
    }

    /**
     * 日期减上多少天前的日期
     * @param now
     * @param day
     * @return
     */
    public static Date dateReduceDay(Date now, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, day * -1);
        return calendar.getTime();
    }

    /**
     * 日期减上多少年前的日期
     * @param now
     * @param year
     * @return
     */
    public static Date dateReduceYear(Date now, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, year * -1);
        return calendar.getTime();
    }

    /**
     * 日期加上多少月后的日期
     *
     * @param now
     * @param month
     * @return
     */
    public static Date dateAddMonth(Date now, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 日期加上多少年后的日期
     *
     * @param now
     * @param year
     * @return
     */
    public static Date dateAddYear(Date now, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 日期加上多少天后的日期
     * @param now
     * @param day
     * @return
     */
    public static Date dateAddDay(Date now, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 日期添加多少天后的日期
     *
     * @param datestr 日期字符串
     * @param day     相对天数，为正数表示之后，为负数表示之前
     * @return 指定日期字符串n天之前或者之后的日期
     */
    public static Date dateAddDate(String datestr, int day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date olddate = null;
        try {
            df.setLenient(false);
            olddate = new java.sql.Date(df.parse(datestr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(olddate);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        int NewDay = Day + day;

        cal.set(Calendar.YEAR, Year);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, NewDay);

        return new Date(cal.getTimeInMillis());
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date   字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 获取当前日期和时间
     *
     * @param format 日期格式 例：yyyy-MM-dd hh:mm
     * @return String
     */
    public static String getNowDate(String format) {
        Date date = new Date();
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat(format);
        str = df.format(date);
        return str;
    }

    /**
     * 根据日期时间获得字符串时间
     *
     * @param dateStr
     * @return
     * @throws Exception
     */
    public static String getTimeStr(String dateStr) throws Exception {
        Date date = getDate(dateStr);
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        str = df.format(date);
        return str;
    }

    /**
     * 根据日期时间获得字符串时间
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String getTimeStr6(Date date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        String str = df.format(date);
        return str;
    }

    /**
     * 取得当前日期
     * @return
     */
    public static String getTimeStr6() {
        String str = "";
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        str = df.format(new Date());
        return str;
    }

    /**
     * 日期添加多少分钟后的时间
     *
     * @param day
     * @param x
     * @return
     */
    public static Date addDateMinut(Date day, int x) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.MINUTE, x);// 24小时制
        day = cal.getTime();
        cal = null;
        return day;

    }

    /**
     * 日期减少多少分钟后的时间
     *
     * @param day
     * @param x
     * @return
     */
    public static String reduceDateMinut(Date day, int x) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.MINUTE, -x);// 24小时制
        day = cal.getTime();
        cal = null;
        return format.format(day);

    }

    /**
     * 获得字符串时间
     *
     * @return
     */
    public static String getTimeStr() {
        String str = "";
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        str = df.format(new Date());
        return str;
    }

    /**
     * 判断字符串是否日期时间格式
     *
     * @param str
     * @return
     */
    public static boolean isDateTime(String str) {
        return isDateTime(str, "yyyy-MM-dd HH:mm:ss.SSS") || isDateTime(str, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 判断字符串是否日期时间格式
     *
     * @param str
     * @return
     */
    public static boolean isDateTime(String str, String pattern) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 判断字符串是否日期格式
     *
     * @param str
     * @return
     */
    public static boolean isDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 获得 这周的第一天
     *
     * @return
     */
    public static Date getThisWeekFirstDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            // 得到当天是这周的第几天
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            // 减去dayOfWeek,得到第一天的日期，因为Calendar用０－６代表一周七天，所以要减一
            calendar.add(Calendar.DAY_OF_WEEK, -(dayOfWeek - 1));
            String beginTime1 = datef.format(calendar.getTime()) + " 00:00:00";
            Date firstDateOfWeek = dateFormat.parse(beginTime1);

            return firstDateOfWeek;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得这周的最后一天
     *
     * @return
     */
    public static Date getThisWeekLastDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            // 得到当天是这周的第几天
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            // 每周7天，加６，得到最后一天的日子
            calendar.add(Calendar.DAY_OF_WEEK, 7 - dayOfWeek);
            String endTime1 = datef.format(calendar.getTime()) + " 23:59:59";
            Date lastDateOfWeek = dateFormat.parse(endTime1);

            return lastDateOfWeek;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得这个月的第一天
     *
     * @return
     */
    public static Date getThisMonthFirstDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            String beginTime1 = datef.format(c.getTime()) + " 00:00:00";
            Date firstDateOfWeek = dateFormat.parse(beginTime1);
            return firstDateOfWeek;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得这个月的最后一天
     *
     * @return
     */
    public static Date getThisMonthLastDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar ca = Calendar.getInstance();
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            String endTime1 = datef.format(ca.getTime()) + " 23:59:59";
            Date lastDateOfWeek = dateFormat.parse(endTime1);

            return lastDateOfWeek;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置时间后获得日期类型
     *
     * @param time
     * @return
     */
    public static Date setTimeGetDate(Date myDate, String time) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = df.parse(DateUtil.getDate(myDate) + " " + time);
            return date;
        } catch (Exception e) {
            try {
                SimpleDateFormat _df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Date date = _df.parse(DateUtil.getDate(myDate) + " " + time);
                return date;
            } catch (Exception _e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取某一天的0时0分0秒时间
     *
     * @param dt
     * @return
     */
    public static Date getStartTimeOfDay(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某一天的23时59分59秒时间
     *
     * @param dt
     * @return
     */
    public static Date getEndTimeOfDay(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取某一天的的下一天的0时0分0秒时间
     *
     * @param dt
     * @return
     */
    public static Date getStartTimeOfNextDay(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 日期加指定天数
     *
     * @param day 天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date d, long day) {

        long time = d.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return new Date(time);

    }

    /**
     * 日期减指定天数
     *
     * @param day 天数
     * @return 返回相减后的日期
     */
    public static Date deleteDate(Date d, long day) {

        long time = d.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time -= day;
        return new Date(time);

    }

    /**
     * 日期之间间隔天数
     * @param before
     * @param after
     * @return
     */
    public static int getBetweenDays(Date before, Date after) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            before = sdf.parse(sdf.format(before));
            after = sdf.parse(sdf.format(after));
            Calendar cal = Calendar.getInstance();
            cal.setTime(before);
            long time1 = cal.getTimeInMillis();
            cal.setTime(after);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            int result = Integer.parseInt(String.valueOf(between_days));
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 时间之间间隔毫秒数
     * @param before
     * @return
     */
    public static int getBetweenDaysWithNow(Date before) {
        try {
            long between_days = (System.currentTimeMillis()-before.getTime()) / (1000 * 3600 * 24);
            int result = Integer.parseInt(String.valueOf(between_days));
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得昨天开始时间
     *
     * @return
     */
    public static Date getYesterdayBegin() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            // 得到当天是这周的第几天
            calendar.add(Calendar.DAY_OF_WEEK, -1);
            String beginTime1 = datef.format(calendar.getTime()) + " 00:00:00";
            Date firstDateOfWeek = dateFormat.parse(beginTime1);

            return firstDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得昨天结束时间
     *
     * @return
     */
    public static Date getYesterdayEnd() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_WEEK, -1);
            String endTime1 = datef.format(calendar.getTime()) + " 23:59:59";
            Date lastDateOfWeek = dateFormat.parse(endTime1);

            return lastDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得本季第一天
     *
     * @return
     */
    public static Date getThisQuarterFirstDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            int month = c.get(Calendar.MONTH) + 1;
            System.out.println(month);
            if (1 == month || 2 == month || 3 == month) {
                c.set(Calendar.MONTH, 12);
            } else if (4 == month || 5 == month || 6 == month) {
                c.set(Calendar.MONTH, 3);
            } else if (7 == month || 8 == month || 9 == month) {
                c.set(Calendar.MONTH, 6);
            } else {
                c.set(Calendar.MONTH, 9);
            }
            String beginTime1 = datef.format(c.getTime()) + " 00:00:00";
            Date firstDateOfWeek = dateFormat.parse(beginTime1);
            return firstDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得本季最后一天
     *
     * @return
     */
    public static Date getThisQuarterLastDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar c = Calendar.getInstance();
            int month = c.get(Calendar.MONTH) + 1;
            if (1 == month || 2 == month || 3 == month) {
                c.set(Calendar.MONTH, 2);
            } else if (4 == month || 5 == month || 6 == month) {
                c.set(Calendar.MONTH, 5);
            } else if (7 == month || 8 == month || 9 == month) {
                c.set(Calendar.MONTH, 8);
            } else {
                c.set(Calendar.MONTH, 11);
            }
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            String endTime1 = datef.format(c.getTime()) + " 23:59:59";
            Date lastDateOfWeek = dateFormat.parse(endTime1);

            return lastDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得本年第一天
     *
     * @return
     */
    public static Date getThisYearFirstDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_YEAR, 1);//设置为1号,当前日期既为本月第一天
            String beginTime1 = datef.format(c.getTime()) + " 00:00:00";
            Date firstDateOfWeek = dateFormat.parse(beginTime1);
            return firstDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得本年最后一天
     *
     * @return
     */
    public static Date getThisYearLastDay() {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar ca = Calendar.getInstance();
            ca.set(Calendar.DAY_OF_YEAR, ca.getActualMaximum(Calendar.DAY_OF_YEAR));
            String endTime1 = datef.format(ca.getTime()) + " 23:59:59";
            Date lastDateOfWeek = dateFormat.parse(endTime1);

            return lastDateOfWeek;
        } catch (Exception e) {
        }
        return null;
    }

    public static Date getDayEnd(Date date) {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            String endTime1 = datef.format(ca.getTime()) + " 23:59:59";
            Date dateEnd = dateFormat.parse(endTime1);

            return dateEnd;
        } catch (Exception e) {
        }
        return null;
    }

    public static Date getDayBegin(Date date) {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            String endTime1 = datef.format(ca.getTime()) + " 00:00:00";
            Date dateEnd = dateFormat.parse(endTime1);

            return dateEnd;
        } catch (Exception e) {
        }
        return null;
    }

    public static String getDayEndStr(Date date) {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            String endTime1 = datef.format(ca.getTime()) + " 23:59:59";
            return endTime1;
        } catch (Exception e) {
        }
        return null;
    }

    public static String getDayBeginStr(Date date) {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            String endTime1 = datef.format(ca.getTime()) + " 00:00:00";
            return endTime1;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 判断日期是否相同
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSame(Date d1, Date d2) {
        try {
            SimpleDateFormat datef = new SimpleDateFormat("yyyyMMdd");
            return datef.format(d1).equals(datef.format(d2));
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 不区分时间比较日期
     *
     * @param before 前日期
     * @param end    后日期
     * @return 等于0，日期相等；大于0，前日期大于后日期；小于0，前日期小于后日期
     */
    public static int compare(Date before, Date end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String beforeStr = sdf.format(before);
        String endStr = sdf.format(end);

        return beforeStr.compareTo(endStr);
    }

    /**
     * 快速获取指定日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static Date getDate(Integer year, Integer month, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}