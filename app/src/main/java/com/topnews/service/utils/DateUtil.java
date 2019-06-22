package com.topnews.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

    public static String convertDateFormat(String date) throws ParseException {

        DateFormat formatterOriginal = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.getDefault());
        formatterOriginal.setTimeZone(TimeZone.getTimeZone("UTC"));

        DateFormat formatterConvert = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault());

        Date da = formatterOriginal.parse(date);
        return formatterConvert.format(da);
    }

}
