package com.yinglan.common;

import android.annotation.TargetApi;
import android.os.Build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateUtils {

    /**
     * 指定格式返回当前系统时间
     *
     * @param format String 想要格式化的日期形式,如"yyyy年MM月dd日 hh:mm"
     * @return 指定格式返回当前系统时间, 如"XXXX年XX月XX日 XX:XX"
     */
    public static String getDataTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        return df.format(new Date());
    }

    //字符串转时间戳

    /**
     * 指定格式字符串转时间戳
     *
     * @param timeString 要转时间戳的字符串，格式指定，如"yyyy年MM月dd日 hh:mm"
     * @return 毫秒值
     */
    public static String getTime(String timeString) {
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
        Date d;
        try {
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeStamp;
    }

    /**
     * 格式化时间
     *
     * @param time 毫秒值
     * @return 返回yyyy-MM-dd格式年月日
     */
    public static String getDataTime(long time) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
    public static String StringPattern(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null)
            return "";
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);        // 实例化模板对象
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);        // 实例化模板对象
        Date d = null;
        try {
            d = sdf1.parse(date);   // 将给定的字符串中的日期提取出来
        } catch (Exception e) {            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace();       // 打印异常信息
        }
        return sdf2.format(d);
    }


    /**
     * 返回当前系统时间(格式以HH:mm形式)
     *
     * @return 返回当前系统时间时分(格式以HH:mm形式)
     */
    public static String getDataTime() {
        return getDataTime("HH:mm");
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
     * 根据当前日期获得是星期几
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
        long yearSeconds = 31536000L;//365 * 24 * 60 * 60;
        long monthSeconds = 2592000L;//30 * 24 * 60 * 60;
        long daySeconds = 86400L;//24 * 60 * 60;
        long hourSeconds = 3600L;//60 * 60;
        long minuteSeconds = 60L;

        long time = (System.currentTimeMillis() - date.getTime()) / 1000;
        if (time <= 50) {
            showStr = "刚刚";
            return showStr;
        }
        if (time / yearSeconds > 0) {
            int year = (int) (time / yearSeconds);
            if (year > 10)
                showStr = "很久以前";
            else {
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
