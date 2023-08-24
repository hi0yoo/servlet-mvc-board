package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfo;
import bit.report.servletmvcboard.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UserUpdateController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUserInfo loginUserInfo = getLoginUserInfo(req);

        String nickname = req.getParameter("nickname");
        UserService.getInstance().update(loginUserInfo.getUserId(), nickname);

        setLoginUserInfo(req, UserService.getInstance().getLoginUserInfo(loginUserInfo.getUserId()));

        resp.sendRedirect("/my-page");
    }
}
