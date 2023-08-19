package com.qmw.commons.utils;

public class FileUtils {

    public static String getFileType(String name) {
        if (name != null && name.contains("."))
            return name.substring(name.lastIndexOf(".") + 1).trim();
        return "";
    }

}
