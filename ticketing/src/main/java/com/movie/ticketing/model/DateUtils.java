package com.movie.ticketing.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyddMM");

    public static Long dateToMilliSecondsConverter(Long date) throws ParseException {
        return DATE_FORMAT.parse(String.valueOf(date)).getTime();

    }

}
