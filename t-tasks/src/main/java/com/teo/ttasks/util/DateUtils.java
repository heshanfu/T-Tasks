package com.teo.ttasks.util;

import android.content.Context;

import java.util.Date;

public class DateUtils extends android.text.format.DateUtils {

    private DateUtils() { }

    private static final int dateFlags = FORMAT_SHOW_DATE | FORMAT_ABBREV_MONTH | FORMAT_SHOW_WEEKDAY | FORMAT_ABBREV_WEEKDAY | FORMAT_SHOW_YEAR;

    private static final int timeFlags = FORMAT_SHOW_TIME;

    public static String formatDate(Context context, Date date) {
        return formatDateTime(context, date.getTime(), dateFlags);
    }

    public static String formatTime(Context context, Date date) {
        return formatDateTime(context, date.getTime(), timeFlags);
    }
}
