package bit.report.servletmvcboard.filter;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/my-page",
        "/user/update",
        "/article/create", "/article/update", "/article/delete", "/article/like", "/article/unlike", "/article/scrap"
})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        LoginUserInfoDto loginUserInfoDto = (LoginUserInfoDto) httpServletRequest.getSession().getAttribute("loginUser");

        if (loginUserInfoDto == null) {
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/WEB-INF/error/401.jsp");
            ((HttpServletResponse) response).setStatus(401);
            rd.forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

}
