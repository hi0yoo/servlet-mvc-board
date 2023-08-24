package bit.report.servletmvcboard.dao.model;

public class ArticleScrap {

    private Long id;
    private Long userId;
    private Long articleId;

    public ArticleScrap() {
    }

    public ArticleScrap(Long id, Long userId, Long articleId) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
