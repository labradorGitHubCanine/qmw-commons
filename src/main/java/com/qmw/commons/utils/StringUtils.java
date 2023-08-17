package com.qmw.commons.utils;

public class StringUtils {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static boolean isEmpty(Object o) {
        return o == null || o.toString().trim().isEmpty();
    }

    public static String ifEmpty(Object o, String s) {
        return isEmpty(o) ? s : o.toString();
    }

    public static String trim(Object o) {
        return ifEmpty(o, "").trim();
    }

    // 驼峰转下划线
    public static String camel2under(String s) {
        if (isEmpty(s))
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i != 0 && Character.isUpperCase(c)) // 首字母不加下划线
                sb.append("_");
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    // 下划线转驼峰
    public static String under2camel(String s) {
        if (isEmpty(s))
            return "";
        String[] arr = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String c = arr[i];
            if (!isEmpty(c)) {
                if (i == 0) // 首字母不转大写
                    sb.append(c);
                else
                    sb.append(Character.toUpperCase(c.charAt(0))).append(c.substring(1));
            }
        }
        return sb.toString();
    }

}
