package com.tao.seaman.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @creater tao
 * @time 2018/6/17
 */
public class HttpUtil {

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean checkAjax(HttpServletRequest request) {
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            return true;
        }
        return false;
    }
}
