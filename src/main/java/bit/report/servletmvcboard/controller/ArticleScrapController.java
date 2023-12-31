package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfo;
import bit.report.servletmvcboard.service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/scrap")
public class ArticleScrapController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String articleIdString = req.getParameter("articleId");
        Long articleId = Long.parseLong(articleIdString);

        LoginUserInfo loginUserInfo = getLoginUserInfo(req);
        ArticleService.getInstance().toggleScrap(loginUserInfo.getUserId(), articleId);

        resp.sendRedirect("/article/detail?article-id=" + articleId);
    }
}
