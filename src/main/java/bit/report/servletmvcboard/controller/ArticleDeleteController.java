package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;
import bit.report.servletmvcboard.service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/delete")
public class ArticleDeleteController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("articleId"));

        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);
        ArticleService.getInstance().deleteArticle(loginUserInfoDto.getUserId(), articleId);

        resp.sendRedirect("/article/list");
    }
}
