package com.qmw.utils;

public class StringUtils {

    public static boolean isEmpty(Object o) {
        return o == null || o.toString().trim().isEmpty();
    }

    public static String ifEmpty(Object o, String s) {
        return isEmpty(o) ? s : o.toString();
    }

    public static String trim(Object o) {
        return ifEmpty(o, "").trim();
    }

}
