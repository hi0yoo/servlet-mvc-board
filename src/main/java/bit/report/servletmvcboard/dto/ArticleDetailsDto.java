package bit.report.servletmvcboard.dto;

import java.time.LocalDateTime;

public class ArticleDetailsDto {

    private Long articleId;
    private UserInfoDto userInfo;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    private int likeCount;
    private int unlikeCount;

    private boolean liked;
    private boolean unliked;

    private boolean scraped;

    public ArticleDetailsDto() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getUnlikeCount() {
        return unlikeCount;
    }

    public void setUnlikeCount(int unlikeCount) {
        this.unlikeCount = unlikeCount;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isUnliked() {
        return unliked;
    }

    public void setUnliked(boolean unliked) {
        this.unliked = unliked;
    }

    public boolean isScraped() {
        return scraped;
    }

    public void setScraped(boolean scraped) {
        this.scraped = scraped;
    }

    @Override
    public String toString() {
        return "ArticleDetailsDto{" +
               "articleId=" + articleId +
               ", userInfo=" + userInfo +
               ", title='" + title + '\'' +
               ", content='" + content + '\'' +
               ", createdAt=" + createdAt +
               ", lastModifiedAt=" + lastModifiedAt +
               ", likeCount=" + likeCount +
               ", unlikeCount=" + unlikeCount +
               ", liked=" + liked +
               ", unliked=" + unliked +
               ", scraped=" + scraped +
               '}';
    }
}
