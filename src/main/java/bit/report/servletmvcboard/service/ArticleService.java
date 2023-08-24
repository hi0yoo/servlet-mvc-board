package bit.report.servletmvcboard.service;

import bit.report.servletmvcboard.config.MybatisManager;
import bit.report.servletmvcboard.dao.ArticleGoodDao;
import bit.report.servletmvcboard.dao.ArticleScrapDao;
import bit.report.servletmvcboard.dao.ArticleBadDao;
import bit.report.servletmvcboard.dao.model.Article;
import bit.report.servletmvcboard.dao.ArticleDao;
import bit.report.servletmvcboard.dao.model.ArticleBad;
import bit.report.servletmvcboard.dao.model.ArticleGood;
import bit.report.servletmvcboard.dao.model.ArticleScrap;
import bit.report.servletmvcboard.dao.param.ArticleListParam;
import bit.report.servletmvcboard.dao.param.UpdateArticleParam;
import bit.report.servletmvcboard.dao.param.UserAndArticleIdParam;
import bit.report.servletmvcboard.dto.ArticleDetailsDto;
import bit.report.servletmvcboard.dto.ArticleSummaryDto;
import bit.report.servletmvcboard.dto.PagingDto;

import java.util.List;

public class ArticleService {

    private static final ArticleService INSTANCE = new ArticleService();

    private final ArticleDao articleDao;
    private final ArticleScrapDao articleScrapDao;
    private final ArticleGoodDao articleGoodDao;
    private final ArticleBadDao articleBadDao;

    private ArticleService() {
        this.articleDao = MybatisManager.getMapper(ArticleDao.class);
        this.articleScrapDao = MybatisManager.getMapper(ArticleScrapDao.class);
        this.articleGoodDao = MybatisManager.getMapper(ArticleGoodDao.class);
        this.articleBadDao = MybatisManager.getMapper(ArticleBadDao.class);
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

    public ArticleDetailsDto getArticleDetails(Long userId, Long articleId) {
        ArticleDetailsDto articleDetailsDto = articleDao.selectArticleDetails(new UserAndArticleIdParam(userId, articleId));

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
    public PagingDto<ArticleSummaryDto> search(String keyword, int page) {
        int totalCount = articleDao.selectArticleSummaryCount(keyword);

        int pageSize = 5;

        int totalPageCount;
        if (totalCount % pageSize == 0) totalPageCount = totalCount / pageSize;
        else totalPageCount = totalCount / pageSize + 1;

        if (totalPageCount != 0 && page >= totalPageCount) {
            throw new RuntimeException("최대 페이지 수를 넘어섰습니다. max-page-number : " + (totalPageCount - 1) +
                                       ", request-page-number : " + page);
        }

        List<ArticleSummaryDto> articleSummaries = articleDao.selectArticleSummaryList(new ArticleListParam(keyword, page, pageSize));
        return new PagingDto<>(articleSummaries, page, totalPageCount - 1);
    }

    public void deleteArticle(Long userId, Long articleId) {
        // TODO check userId
        articleDao.deleteArticle(articleId);
    }

    public void toggleLike(Long userId, Long articleId) {
        // 좋아요 조회
        UserAndArticleIdParam daoParam = new UserAndArticleIdParam(userId, articleId);
        ArticleGood articleGood = articleGoodDao.selectArticleGood(daoParam);

        // 좋아요 있으면 좋아요 삭제. 종료
        if (articleGood != null) {
            articleGoodDao.deleteArticleGood(articleGood.getNum());
            return;
        }

        // 좋아요 없으면 싫어요 조회
        ArticleBad articleBad = articleBadDao.selectArticleBad(daoParam);
        // 싫어요 없으면 좋아요 insert. 종료.
        if (articleBad == null) {
            articleGoodDao.insertArticleGood(new ArticleGood(null, userId, articleId));
            return;
        }
        // 싫어요 있으면 싫어요 delete, 좋아요 insert. 종료
        articleBadDao.deleteArticleBad(articleBad.getNum());
        articleGoodDao.insertArticleGood(new ArticleGood(null, userId, articleId));
    }

    public void toggleUnlike(Long userId, Long articleId) {
        // 싫어요 조회
        UserAndArticleIdParam daoParam = new UserAndArticleIdParam(userId, articleId);
        ArticleBad articleBad = articleBadDao.selectArticleBad(daoParam);

        // 싫어요 있으면 싫어요 삭제. 종료
        if (articleBad != null) {
            articleBadDao.deleteArticleBad(articleBad.getNum());
            return;
        }

        // 싫어요 없으면 좋아요 조회
        ArticleGood articleGood = articleGoodDao.selectArticleGood(daoParam);
        // 좋아요 없으면 싫어요 insert. 종료.
        if (articleGood == null) {
            articleBadDao.insertArticleBad(new ArticleBad(null, userId, articleId));
            return;
        }
        // 좋아요 있으면 좋아요 delete, 싫어요 insert. 종료
        articleGoodDao.deleteArticleGood(articleGood.getNum());
        articleBadDao.insertArticleBad(new ArticleBad(null, userId, articleId));
    }

    public void toggleScrap(Long userId, Long articleId) {
        // article-scrap 조회
        ArticleScrap articleScrap = articleScrapDao.selectArticleScrap(new UserAndArticleIdParam(userId, articleId));
        // 있으면 삭제
        if (articleScrap != null) articleScrapDao.deleteArticleScrap(articleScrap.getId());
        // 없으면 추가
        else articleScrapDao.insertArticleScrap(new ArticleScrap(null, userId, articleId));
    }

    public List<ArticleSummaryDto> getScrapedArticleList(Long userId) {
        return articleDao.selectArticleSummaryListByScrapUserId(userId);
    }

    public List<ArticleSummaryDto> getLikedArticleList(Long userId) {
        return articleDao.selectArticleSummaryListByLikedUserId(userId);
    }

    public List<ArticleSummaryDto> getUnlikedArticleList(Long userId) {
        return articleDao.selectArticleSummaryListByUnlikedUserId(userId);
    }
}
