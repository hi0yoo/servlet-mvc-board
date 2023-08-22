package bit.report.servletmvcboard.dto;

import java.util.List;

public class PagingDto<T> {

    private List<T> results;
    private int currentPageNumber;
    private int lastPageNumber;
    private boolean isFirstPage;
    private boolean isLastPage;

    public PagingDto(List<T> results, int currentPageNumber, int lastPageNumber) {
        this.results = results;
        this.currentPageNumber = currentPageNumber;
        this.lastPageNumber = lastPageNumber;
        this.isFirstPage = currentPageNumber <= 0;
        this.isLastPage = currentPageNumber >= this.lastPageNumber;
    }

    public PagingDto() {
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    public void setLastPageNumber(int lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}
