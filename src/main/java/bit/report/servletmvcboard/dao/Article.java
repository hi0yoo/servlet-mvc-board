package bit.report.servletmvcboard.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Article {

    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    private Article(Long id, Long writerId, String title, String content, LocalDateTime createdAt, LocalDateTime lastModifiedAt) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    @Builder
    public Article(Long writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;

        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.lastModifiedAt = now;
    }
}
