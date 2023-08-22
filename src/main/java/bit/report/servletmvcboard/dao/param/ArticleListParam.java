package bit.report.servletmvcboard.dao.param;

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

    public ArticleListParam() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
