package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String DATE_FORMAT = "dd/MM/yyyy";

    public static String getFormattedDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date);
    }

    public static Date getDateFromFormatted(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String goToFutureFormatted(String date, int days, int monthes, int year){
        String futureFormatted = null;
        Date futureDate = getDateFromFormatted(date);
        if (futureDate == null){
            futureDate = new Date();
        }

        if (futureDate != null){
            Calendar c = Calendar.getInstance();
            c.setTime(futureDate);
            c.add(Calendar.DATE, days);
            c.add(Calendar.MONTH, monthes);
            c.add(Calendar.YEAR, year);

            futureFormatted = getFormattedDate(c.getTime());
        }

        return futureFormatted;
    }
}
