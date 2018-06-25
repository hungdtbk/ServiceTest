package com.tohsoft.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by hungdt on 5/2/2018
 */
public class DateUtil {
    public static String getHHmmString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm", Locale.US);
        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getTodayString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getYesterdayString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return dateFormat.format(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }

    public static String getThisWeekString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year) + "W" + String.valueOf(week);
    }

    public static String getThisMonthString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM", Locale.US);
        return dateFormat.format(System.currentTimeMillis());
    }
}
