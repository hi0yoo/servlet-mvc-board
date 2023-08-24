package bit.report.servletmvcboard.dao.model;

public class ArticleBad {

    private Long num;
    private Long userId;
    private Long articleId;

    public ArticleBad() {
    }

    public ArticleBad(Long num, Long userId, Long articleId) {
        this.num = num;
        this.userId = userId;
        this.articleId = articleId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
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
