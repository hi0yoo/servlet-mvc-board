package bit.report.servletmvcboard.dao.param;

public class UserAndArticleIdParam {

    private Long userId;
    private Long articleId;

    public UserAndArticleIdParam(Long userId, Long articleId) {
        this.userId = userId;
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getArticleId() {
        return articleId;
    }
}
