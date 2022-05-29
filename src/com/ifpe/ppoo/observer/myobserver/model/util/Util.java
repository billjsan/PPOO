package com.ifpe.ppoo.observer.myobserver.model.util;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Util {

//    public final static int DATE_SEPARATOR_ASH = 0;
//    public final static int DATE_SEPARATOR_COMMA = 1;
//    public final static int DATE_SEPARATOR_INV_ASH = 2;
//    public final static int DATE_SEPARATOR_DEFAULT = -1;
//
//    public final static int TIME_SEPARATOR_INV_ASH = -1;
//    public final static int TIME_SEPARATOR_ASH = -2;
//    public final static int TIME_SEPARATOR_COMMA = -3;
//    public final static int TIME_SEPARATOR_DEFAULT = 0;
//
//    private static final String defaultDatePattern = "DD-MM-YYYY";
//    private static final String defaultTimePattern = "-";
//    private static String currentDatePattern = defaultDatePattern;
//    private static String currentTimePattern = defaultTimePattern;

//    public static void setTimePattern(int separatorPattern) {
//        switch (separatorPattern) {
//            case -1 -> currentTimePattern = "\\";
//            case -2 -> currentTimePattern = "/";
//            case -3 -> currentTimePattern = ":";
//            default -> currentTimePattern = "-";
//        }
//    }

//    public static void setDatePattern(int separatorPattern) {
//        switch (separatorPattern) {
//            case 0 -> currentDatePattern = "dd/MM/YYYY";
//            case 1 -> currentDatePattern = "dd:MM:YYYY";
//            case 2 -> currentDatePattern = "dd\\MM\\YYYY";
//            default -> currentDatePattern = "dd-MM-YYYY";
//        }
//    }

//    public static String formattedDate() {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(currentDatePattern);
//        return now.format(formatter);
//    }

//    public static String formattedDateAndTime() {
//
//        return formattedDate() + " "
//                + LocalTime.now().getHour() + currentTimePattern
//                + LocalTime.now().getMinute() + currentTimePattern
//                + LocalTime.now().getSecond();
//    }

//    public static String measurePresenceSimulate() {
//
//        SecureRandom secureRandom = new SecureRandom();
//        int value = secureRandom.nextInt(2);
//
//        if (value == 0) {
//            return "false";
//        }
//        return "true";
//    }
}
