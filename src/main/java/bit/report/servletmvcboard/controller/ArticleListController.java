package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.ArticleSummaryDto;
import bit.report.servletmvcboard.dto.PagingDto;
import bit.report.servletmvcboard.service.ArticleService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/list")
public class ArticleListController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String pageString = req.getParameter("page");
        int page = 0;
        if (!(pageString == null) && !pageString.isEmpty()) page = Integer.parseInt(pageString);

        PagingDto<ArticleSummaryDto> pagingDto = ArticleService.getInstance().search(keyword, page);
        req.setAttribute("pagingDto", pagingDto);

        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("article/list"));
        rd.forward(req, resp);
    }
}
