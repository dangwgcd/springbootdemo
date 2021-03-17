package com.my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wt on 2017/12/12.
 */
public class DateUtil {
    public static String getNowDate() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
