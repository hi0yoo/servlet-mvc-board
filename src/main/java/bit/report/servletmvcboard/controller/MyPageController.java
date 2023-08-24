package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.ArticleSummaryDto;
import bit.report.servletmvcboard.dto.LoginUserInfoDto;
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
        LoginUserInfoDto loginUserInfoDto = getLoginUserInfo(req);

        // 좋아요 리스트 조회
        List<ArticleSummaryDto> likedArticleList = ArticleService.getInstance().getLikedArticleList(loginUserInfoDto.getUserId());
        req.setAttribute("likedArticleList", likedArticleList);

        // 싫어요 리스트 조회
        List<ArticleSummaryDto> unlikedArticleList = ArticleService.getInstance().getUnlikedArticleList(loginUserInfoDto.getUserId());
        req.setAttribute("unlikedArticleList", unlikedArticleList);

        // 스크랩 리스트 조회
        List<ArticleSummaryDto> scrapedArticleList = ArticleService.getInstance().getScrapedArticleList(loginUserInfoDto.getUserId());
        req.setAttribute("scrapedArticleList", scrapedArticleList);

        RequestDispatcher rd = req.getRequestDispatcher(resolvePath("user/my-page"));
        rd.forward(req, resp);
    }
}
