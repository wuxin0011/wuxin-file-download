package com.wuxin.interceptor;

import com.wuxin.exception.CustomException;
import com.wuxin.exception.UnauthenticatedException;
import com.wuxin.pojo.User;
import com.wuxin.utils.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:10
 * @Description: 文件上传拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (StringUtil.isEmpty(requestURI)) {
            return true;
        }
        // 值包含amdin路径下的 添加删除修改操作
        if (requestURI.contains("/admin")) {
            if (requestURI.contains("/add") || requestURI.contains("/update") || requestURI.contains("/delete")) {
                User loginUser = (User) request.getSession().getAttribute("loginUser");
                if (loginUser == null) {
                    return false;
                }
                if (loginUser.getRole() != null && loginUser.getRole() == 1) {
                    return true;
                }
                // 没权限抛出异常
                throw new UnauthenticatedException();
            }
        }
        return true;
    }
}
