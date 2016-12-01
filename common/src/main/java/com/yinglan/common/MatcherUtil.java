package com.yinglan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：正则表达式工具类
 */
public class MatcherUtil {

    //首位是1，长度11位
    public static boolean isPhone(String mobiles) {
//        Pattern p = Pattern
//                .compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Pattern p = Pattern
                .compile("^1\\d{10}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    //6到16个数字字母的组合
    public static boolean isPassword(String mobiles) {
        Pattern p = Pattern
                .compile("[0-9a-zA-Z_]{6,16}");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    //2到12个汉字字母数字组合
    public static boolean isName(String name) {
        Pattern p = Pattern
                .compile("[\\u4E00-\\u9FA5a-zA-Z0-9]{2,12}");
        Matcher m = p.matcher(name);
        return m.matches();
    }


    //二代合法身份证格式
    public static boolean isIDCard(String idcard) {
        Pattern p = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher m = p.matcher(idcard);
        return m.matches();
    }


    //邮编格式
    public static boolean isPostCode(String code) {
        Pattern p = Pattern.compile("[1-9]\\d{5}(?!\\d)");
        Matcher m = p.matcher(code);
        return m.matches();
    }

}
