package com.tao.seaman.common.base;

import com.tao.seaman.common.util.HttpUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller基类
 * @creater tao
 * @time 2018/6/17
 */
public abstract class BaseController {

    /**
     * 日志
     */
    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(BaseController.class);

    /**
     * 统一异常处理
     * @param request
     * @param response
     * @param exception
     * @return
     */
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        LOGGER.error("统一异常处理: " + exception);
        request.setAttribute("exception", exception);
        // 判断是否是ajax请求
        if (HttpUtil.checkAjax(request)) {
            request.setAttribute("requestHeader", "ajax");
        }
        // shiro没有权限 异常
        if (exception instanceof UnauthorizedException) {
            return "/403.html";
        }
        // shiro会话已过期 异常
        if (exception instanceof InvalidSessionException) {
            return "/error.html";
        }
        return "error.html";
    }
}
