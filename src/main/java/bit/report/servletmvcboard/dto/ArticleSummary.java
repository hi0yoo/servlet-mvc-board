package bit.report.servletmvcboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSummary {

    private Long articleId;
    private UserInfoDto userInfo;
    private String title;
    private LocalDateTime createdAt;
}
