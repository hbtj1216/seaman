package com.tao.seaman.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 *
 * @creater tao
 * @time 2018/6/17
 */
public class CookieUtil {

    /**
     * 设置Cookie
     *
     * @param response HttpServletResponse对象
     * @param name     Cookie中的键
     * @param value    Cookie中键对应的值
     * @param path     同一path下共享Cookie
     * @param maxAge   最大存活时间
     */
    public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 设置Cookie
     *
     * @param response HttpServletResponse对象
     * @param name     Cookie中的键
     * @param value    Cookie中键对应的值
     * @param maxAge   最大存活时间
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        setCookie(response, name, value, "/", maxAge);
    }

    /**
     * 设置Cookie, 默认存活时间为3600秒
     *
     * @param response HttpServletResponse对象
     * @param name     Cookie中的键
     * @param value    Cookie中键对应的值
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, 3600);
    }

    /**
     * 设置Cookie, 默认存活时间为3600秒, 键的值为""
     *
     * @param response HttpServletResponse对象
     * @param name     Cookie中的键
     */
    public static void setCookie(HttpServletResponse response, String name) {
        setCookie(response, name, "");
    }

    /**
     * 获取Cookie
     *
     * @param request HttpServletRequest对象
     * @param name    键
     * @return
     */
    public static String getCookie(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    /**
     * 删除Cookie
     *
     * @param response HttpServletResponse对象
     * @param name     键
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        // 设置maxAge为0, 表示删除对应的Cookie
        setCookie(response, name, "", "/", 0);
    }
}










