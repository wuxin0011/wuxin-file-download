package com.wuxin.utils;

import com.wuxin.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:11
 * @Description: 网络工具类
 */
public class ServletUtil {

    private static String loginUser = "loginUser";


    /**
     * 从当前线程中获取请求对象信息
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }


    /**
     * 从ServletRequestAttributes 中 获取 request属性
     *
     * @return request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 从ServletRequestAttributes 中 获取 request属性
     *
     * @return request
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }


    /**
     * HttpServletRequest 中 获取 session
     *
     * @return session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static void saveLoginUser(User user) {
        if (user == null) {
            return;
        }
        // 登录用户清空密码，保护密码
        user.setPassword(null);
        getSession().setAttribute(loginUser, user);
    }

    public static User getLoginUser() {
        return (User) getSession().getAttribute(loginUser);
    }


}
