package bit.report.servletmvcboard.dto;

import java.time.LocalDateTime;

public class ArticleSummary {

    private Long articleId;
    private UserInfoDto userInfo;
    private String title;
    private LocalDateTime createdAt;

    public ArticleSummary() {
    }

    public ArticleSummary(Long articleId, UserInfoDto userInfo, String title, LocalDateTime createdAt) {
        this.articleId = articleId;
        this.userInfo = userInfo;
        this.title = title;
        this.createdAt = createdAt;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
