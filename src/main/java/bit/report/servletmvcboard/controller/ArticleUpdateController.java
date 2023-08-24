package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.ArticleDetailsDto;
import bit.report.servletmvcboard.dto.LoginUserInfoDto;
import bit.report.servletmvcboard.service.ArticleService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/update")
public class ArticleUpdateController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.valueOf(req.getParameter("article-id"));

        // TODO 작성자 확인
        // TODO when ArticleDetails null
        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);
        ArticleDetailsDto articleDetails = ArticleService.getInstance().getArticleDetails(loginUserInfoDto.getUserId(), articleId);
        req.setAttribute("articleDetails", articleDetails);

        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("article/update"));
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);

        // TODO 작성자 확인

        Long articleId = Long.valueOf(req.getParameter("article-id"));

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        ArticleService.getInstance().updateArticle(loginUserInfoDto.getUserId(), articleId, title, content);

        resp.sendRedirect("/article/detail?article-id=" + articleId);
    }
}
