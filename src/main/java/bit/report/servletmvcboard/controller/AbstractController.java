package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfo;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController extends HttpServlet {

    private static final String SESSION_ATTR_NAME_LOGIN_USER = "loginUser";

    protected static final String VIEW_PREFIX = "/WEB-INF/views/";
    protected static final String VIEW_SUFFIX = ".jsp";

    protected String resolvePath(String path) {
        return VIEW_PREFIX + path + VIEW_SUFFIX;
    }

    protected static void setLoginUserInfo(HttpServletRequest request, LoginUserInfo loginUserInfo) {
        request.getSession().setAttribute(SESSION_ATTR_NAME_LOGIN_USER, loginUserInfo);
    }

    protected static LoginUserInfo getLoginUserInfo(HttpServletRequest request) {
        return (LoginUserInfo) request.getSession().getAttribute(SESSION_ATTR_NAME_LOGIN_USER);
    }
}
