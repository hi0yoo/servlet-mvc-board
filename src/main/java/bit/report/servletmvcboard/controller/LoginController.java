package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;
import bit.report.servletmvcboard.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("user/login"));
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginUserInfoDto loginUserInfoDto = UserService.getInstance().getLoginUserInfoBy(username, password);

        setLoginUserInfo(req, loginUserInfoDto);

        resp.sendRedirect("/article/list");
    }
}
