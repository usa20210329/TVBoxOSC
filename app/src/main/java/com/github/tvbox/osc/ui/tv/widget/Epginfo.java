package com.github.tvbox.osc.ui.tv.widget;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Epginfo {

    public Date startdateTime;
    public Date enddateTime;
    public int datestart;
    public int dateend;
    public String title;
    public String originStart;
    public String originEnd;
    public String start;
    public String end;

    public Epginfo(String str, Date date, String str1, String str2) {

        title = str;
        originStart = str1;
        originEnd = str2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat userSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        userSimpleDateFormat.setTimeZone(TimeZone.getDefault());
        startdateTime = userSimpleDateFormat.parse(simpleDateFormat.format(date) + " " + str1 + ":00 GMT+8:00", new ParsePosition(0));
        enddateTime = userSimpleDateFormat.parse(simpleDateFormat.format(date) + " " + str2 + ":00 GMT+8:00", new ParsePosition(0));
        SimpleDateFormat zoneFormat = new SimpleDateFormat("HH:mm");
        start = zoneFormat.format(startdateTime);
        end = zoneFormat.format(enddateTime);
        datestart = Integer.parseInt(start.replace(":", ""));
        dateend = Integer.parseInt(end.replace(":", ""));
    }
}
