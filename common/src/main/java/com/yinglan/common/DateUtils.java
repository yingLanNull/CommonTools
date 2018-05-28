package com.yinglan.common;

import android.annotation.TargetApi;
import android.os.Build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


public class DateUtils {

    /**
     * 指定格式返回当前系统时间
     *
     * @param format String 想要格式化的日期形式,如"yyyy年MM月dd日 HH:mm"
     * @return 指定格式返回当前系统时间, 如"XXXX年XX月XX日 XX:XX"
     */
    public static String getFormatNowTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(new Date());
    }

    /**
     * 格式化时间
     *
     * @param date   Date对象
     * @param format String 想要格式化的日期形式,如"yyyy年MM月dd日 HH:mm"
     * @return 返回指定格式返回当前系统时间, 如"XXXX年XX月XX日 XX:XX"
     */
    public static String getFormatTime(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(date);
    }

    /**
     * 格式化时间
     *
     * @param time   毫秒值
     * @param format String 想要格式化的日期形式,如"yyyy年MM月dd日 HH:mm"
     * @return 返回指定格式返回当前系统时间, 如"XXXX年XX月XX日 XX:XX"
     */
    public static String getFormatTime(long time, String format) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(d);
    }

    /**
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日").
     *
     * @param date       String 想要格式化的日期,如"2011-11-11"
     * @param oldPattern String 想要格式化的日期的现有格式,如"yyyy-MM-dd"
     * @param newPattern String 想要格式化成什么格式,如"yyyy年MM月dd日"
     * @return 返回格式化完成的字符串
     */
    public static String getFormatTime(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null) {
            return "";
        }
        // 实例化模板对象
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);
        // 实例化模板对象
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);
        Date d = null;
        try {
            // 将给定的字符串中的日期提取出来
            d = sdf1.parse(date);
        } catch (Exception e) {
            // 如果提供的字符串格式有错误，则进行异常处理
            // 打印异常信息
            e.printStackTrace();
        }
        return sdf2.format(d);
    }

    /**
     * 指定格式字符串转时间戳
     *
     * @param date 要转时间戳的字符串，格式指定包括"yyyy-MM-dd hh:mm:ss",
     *             "yyyyMMddHHmmss","yyyyMMdd","yyyy-MM-dd","yyyy-MM-dd  HH:mm"五种形式
     * @return 毫秒值
     */
    public static long getLongTime(String date) {
        date = date.trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //yyyyMMddHHmmss
        String a1 = "[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}";
        //yyyyMMdd
        String a2 = "[0-9]{4}[0-9]{2}[0-9]{2}";
        //yyyy-MM-dd HH:mm:ss
        String a3 = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
        //yyyy-MM-dd
        String a4 = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        //yyyy-MM-dd  HH:mm
        String a5 = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}";
        boolean datea1 = Pattern.compile(a1).matcher(date).matches();
        if (datea1) {
            sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        }
        boolean datea2 = Pattern.compile(a2).matcher(date).matches();
        if (datea2) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        boolean datea3 = Pattern.compile(a3).matcher(date).matches();
        if (datea3) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        boolean datea4 = Pattern.compile(a4).matcher(date).matches();
        if (datea4) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        boolean datea5 = Pattern.compile(a5).matcher(date).matches();
        if (datea5) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        long l = 0L;
        Date d;
        try {
            date = date.trim();
            d = sdf.parse(date);
            l = d.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }


    /**
     * 是不是当日
     *
     * @param when 毫秒值
     * @return 是不是当日布尔值
     */
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public static boolean isToday(long when) {
        android.text.format.Time time = new android.text.format.Time();
        time.set(when);

        int thenYear = time.year;
        int thenMonth = time.month;
        int thenMonthDay = time.monthDay;

        time.set(System.currentTimeMillis());
        return (thenYear == time.year)
                && (thenMonth == time.month)
                && (time.monthDay == thenMonthDay);
    }


    /**
     * 根据传入日期获得是星期几
     *
     * @param date Date对象
     * @return 返回周几
     */
    public static String getWeek(Date date) {
        if (null != date) {
            String time = getFormatTime(date, "yyyy-MM-dd");
            return getWeek(time);
        } else {
            return "格式错误";
        }
    }

    /**
     * 根据传入日期获得是星期几
     *
     * @param time yyyy-MM-dd格式年月日字符串
     * @return 返回周几
     */
    public static String getWeek(String time) {
        String Week = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }


    /****************************************************/

    /**
     * 转换日期到指定格式方便查看的描述说明
     *
     * @param time 毫秒值
     * @return 今天，几天前，几个月前，几年前，很久以前（10年前）,如果出现之后的时间，则提示：未知
     */
    public static String getTimeLineTwo(long time) {
        Date date = new Date(time);
        return getTimeLineTwo(date);
    }

    /**
     * 转换日期到指定格式方便查看的描述说明
     *
     * @param date Date对象
     * @return 今天，几天前，几个月前，几年前，很久以前（10年前）,如果出现之后的时间，则提示：未知
     */
    public static String getTimeLineTwo(Date date) {
        String showStr = "";
        if (isToday(date.getTime())) {
            showStr = "今天";
        } else {
            showStr = getTimeLineOne(date);
        }
        return showStr;
    }

    /**
     * 转换日期到指定格式方便查看的描述说明
     *
     * @param time 毫秒值
     * @return 几秒前，几分钟前，几小时前，几天前，几个月前，几年前，很久以前（10年前）,如果出现之后的时间，则提示：未知
     */
    public static String getTimeLineOne(long time) {
        Date date = new Date(time);
        return getTimeLineOne(date);
    }

    /**
     * 转换日期到指定格式方便查看的描述说明
     *
     * @param date Date对象
     * @return 几秒前，几分钟前，几小时前，几天前，几个月前，几年前，很久以前（10年前）,如果出现之后的时间，则提示：未知
     */
    public static String getTimeLineOne(Date date) {
        String showStr = "";
        //365 * 24 * 60 * 60;
        long yearSeconds = 31536000L;
        //30 * 24 * 60 * 60;
        long monthSeconds = 2592000L;
        //24 * 60 * 60;
        long daySeconds = 86400L;
        //60 * 60;
        long hourSeconds = 3600L;
        long minuteSeconds = 60L;

        long time = (System.currentTimeMillis() - date.getTime()) / 1000;
        if (time <= 50) {
            showStr = "刚刚";
            return showStr;
        }
        if (time / yearSeconds > 0) {
            int year = (int) (time / yearSeconds);
            if (year > 10) {
                showStr = "很久以前";
            } else {
                showStr = year + "年前";
            }
        } else if (time / monthSeconds > 0) {
            showStr = time / monthSeconds + "个月前";
        } else if (time / daySeconds > 7) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd", Locale.getDefault());
            showStr = formatter.format(date);
        } else if (time / daySeconds > 0) {
            showStr = time / daySeconds + "天前";
        } else if (time / hourSeconds > 0) {
            showStr = time / hourSeconds + "小时前";
        } else if (time / minuteSeconds > 0) {
            showStr = time / minuteSeconds + "分钟前";
        } else if (time > 0) {
            showStr = time + "秒前";
        }
        return showStr;
    }
}
