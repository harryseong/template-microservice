package com.harryseong.templatemicroservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {

    private static final String TIME_FORMATTER = "HH:mm:ss";

    public static String getCurrentTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMATTER);
        return LocalDateTime.now().format(formatter);
    }

    public static String compressString(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int currentCharCount = 0;
        Character previous = null;
        while (index < s.length()) {
            char current = s.charAt(index);

            if (index == 0) {
                sb.append(current);
                previous = current;
                currentCharCount++;
            } else if (index < s.length() - 1) {
                if (previous == current) {
                    currentCharCount++;
                } else {
                    sb.append(currentCharCount).append(current);
                    previous = current;
                    currentCharCount = 1;
                }
            } else {
                if (previous == current) {
                    currentCharCount++;
                    sb.append(currentCharCount);
                } else sb.append(current).append(1);
            }

            index++;
        }

        String compressed = sb.toString();
        return s.length() <= compressed.length() ? s : compressed ;
    }
}
