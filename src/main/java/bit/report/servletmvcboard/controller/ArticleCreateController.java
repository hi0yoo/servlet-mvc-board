package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfoDto;
import bit.report.servletmvcboard.service.ArticleService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/create")
public class ArticleCreateController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("article/create"));
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Long articleId = ArticleService.getInstance().createArticle(loginUserInfoDto.getUserId(), title, content);

        resp.sendRedirect("/article/detail?article-id=" + articleId);
    }
}
