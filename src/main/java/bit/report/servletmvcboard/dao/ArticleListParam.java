package bit.report.servletmvcboard.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleListParam {

    private String keyword;
    private int page;
    private int pageSize;
    private int offset;

    public ArticleListParam(String keyword, int page, int pageSize) {
        this.keyword = keyword;
        this.page = page;
        this.pageSize = pageSize;
        this.offset = page * pageSize;
    }
}
