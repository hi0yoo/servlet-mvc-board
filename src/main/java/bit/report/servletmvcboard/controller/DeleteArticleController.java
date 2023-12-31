package bit.report.servletmvcboard.controller;

import bit.report.servletmvcboard.dto.LoginUserInfo;
import bit.report.servletmvcboard.service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/delete")
public class DeleteArticleController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("articleId"));

        LoginUserInfo loginUserInfo = getLoginUserInfo(req);
        ArticleService.getInstance().deleteArticle(loginUserInfo.getUserId(), articleId);

        resp.sendRedirect("/article/list");
    }
}
