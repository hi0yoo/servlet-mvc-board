package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.ArticleSummary;
import bit.report.servletmvcboard.dto.LoginUserInfo;
import bit.report.servletmvcboard.service.ArticleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/my-page")
public class MyPageController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUserInfo loginUserInfo = getLoginUserInfo(req);

        // 스크랩 리스트 조회
        List<ArticleSummary> scrapedArticleList = ArticleService.getInstance().getScrapedArticleList(loginUserInfo.getUserId());
        req.setAttribute("scrapedArticleList", scrapedArticleList);

        // TODO 좋아요, 싫어요 리스트 조회

        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("user/my-page"));
        rd.forward(req, resp);
    }
}
