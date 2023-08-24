package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;
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
        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);

        String nickname = req.getParameter("nickname");
        UserService.getInstance().update(loginUserInfoDto.getUserId(), nickname);

        setLoginUserInfo(req, UserService.getInstance().getLoginUserInfoBy(loginUserInfoDto.getUserId()));

        resp.sendRedirect("/my-page");
    }
}
