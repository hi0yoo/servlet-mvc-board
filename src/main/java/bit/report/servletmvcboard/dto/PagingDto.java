package bit.report.servletmvcboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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
}
