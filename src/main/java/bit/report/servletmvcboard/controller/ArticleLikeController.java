package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;
import bit.report.servletmvcboard.service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/like")
public class ArticleLikeController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String articleIdString = req.getParameter("articleId");
        Long articleId = Long.parseLong(articleIdString);

        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);
        ArticleService.getInstance().toggleLike(loginUserInfoDto.getUserId(), articleId);

        resp.sendRedirect("/article/detail?article-id=" + articleId);
    }
}
