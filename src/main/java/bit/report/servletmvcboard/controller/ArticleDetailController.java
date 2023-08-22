package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.ArticleDetailsDto;
import bit.report.servletmvcboard.service.ArticleService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/detail")
public class ArticleDetailController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.valueOf(req.getParameter("article-id"));
        ArticleDetailsDto articleDetails = ArticleService.getInstance().getArticleDetails(articleId);

        req.setAttribute("articleDetails", articleDetails);

        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("article/detail"));
        rd.forward(req, resp);
    }
}
