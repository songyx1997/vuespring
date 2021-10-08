package com.example.interceptor;

import com.example.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title: UserInterceptor</p>
 * <p>Description: 登录与注册拦截器</p>
 * @author songy
 * @date 2021/10/8
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        //需要拦截的路径列表
        String[] requireAuthPages = {"index"};
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath + "/");
        if (isBeginWith(uri, requireAuthPages)) {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                //重定向至登录与注册页面
                response.sendRedirect("user");
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Title: isBeginWith</p>
     * <p>Description: 校验待访问页面是否在需要拦截的路径列表中</p>
     * @param page 待访问页面
     * @param requiredAuthPages 需要拦截的路径列表
     * @return boolean
     */
    private boolean isBeginWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if (StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
