package com.mqd.utils;


import java.time.Instant;

public class TimeStatistic {
    public static void func(Runnable r) {
        Instant s = Instant.now();
        r.run();
        Instant e = Instant.now();
        System.out.println(parseTime(e.toEpochMilli() - s.toEpochMilli()));
    }

    private static String parseTime(long l) {
        long ms = l % 1000;
        l /= 1000;
        long s = l % 1000;
        l /= 1000;
        long m = l / 60;
        return m + "m " + s + "s " + ms + "ms ";
    }
}
