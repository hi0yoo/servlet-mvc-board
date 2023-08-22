package bit.report.servletmvcboard.service;

import bit.report.servletmvcboard.config.MybatisManager;
import bit.report.servletmvcboard.dao.model.Article;
import bit.report.servletmvcboard.dao.ArticleDao;
import bit.report.servletmvcboard.dao.param.ArticleListParam;
import bit.report.servletmvcboard.dao.param.UpdateArticleParam;
import bit.report.servletmvcboard.dto.ArticleDetailsDto;
import bit.report.servletmvcboard.dto.ArticleSummary;
import bit.report.servletmvcboard.dto.PagingDto;

import java.util.List;

public class ArticleService {

    private static final ArticleService INSTANCE = new ArticleService();

    private final ArticleDao articleDao;

    private ArticleService() {
        this.articleDao = MybatisManager.getMapper(ArticleDao.class);
    }

    public static ArticleService getInstance() {
        return INSTANCE;
    }

    public Long createArticle(Long writerId, String title, String content) {
        // TODO writerId 검증
        Article article = new Article(writerId, title, content);

        articleDao.insertArticle(article);

        return article.getId();
    }

    public ArticleDetailsDto getArticleDetails(Long articleId) {
        ArticleDetailsDto articleDetailsDto = articleDao.selectArticleDetails(articleId);

        if (articleDetailsDto == null) {
            // TODO article not found exception
            throw new RuntimeException("게시글이 존재하지 않습니다");
        }

        return articleDetailsDto;
    }

    public void updateArticle(Long userId, Long articleId, String title, String content) {
        // TODO check userId
        articleDao.updateArticle(new UpdateArticleParam(articleId, title, content));
    }

    // search, paging
    public PagingDto<ArticleSummary> search(String keyword, int page) {
        int totalCount = articleDao.selectArticleSummaryCount(keyword);

        int pageSize = 5;

        int totalPageCount;
        if (totalCount % pageSize == 0) totalPageCount = totalCount / pageSize;
        else totalPageCount = totalCount / pageSize + 1;

        if (totalPageCount != 0 && page >= totalPageCount) {
            throw new RuntimeException("최대 페이지 수를 넘어섰습니다. max-page-number : " + (totalPageCount - 1) +
                                       ", request-page-number : " + page);
        }

        List<ArticleSummary> articleSummaries = articleDao.selectArticleSummaryList(new ArticleListParam(keyword, page, pageSize));
        return new PagingDto<>(articleSummaries, page, totalPageCount - 1);
    }

    public void deleteArticle(Long userId, Long articleId) {
        // TODO check userId
        articleDao.deleteArticle(articleId);
    }
}
