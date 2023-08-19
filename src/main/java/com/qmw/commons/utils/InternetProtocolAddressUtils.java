package com.qmw.commons.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

public class InternetProtocolAddressUtils {

    public static String getInternetProtocolAddress(HttpServletRequest request) {
        return Stream.of(
                request.getHeader("x-forwarded-for"),
                request.getHeader("Proxy-Client-IP"),
                request.getHeader("WL-Proxy-Client-IP"),
                request.getHeader("HTTP_CLIENT_IP"),
                request.getHeader("HTTP_X_FORWARDED_FOR"),
                request.getRemoteAddr()
        ).filter(e ->
                !StringUtils.isEmpty(e) && !StringUtils.trim(e).equalsIgnoreCase("unknown")
        ).findFirst().orElse("");
    }

}
