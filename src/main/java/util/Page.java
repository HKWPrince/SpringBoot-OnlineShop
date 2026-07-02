package util;

import java.util.List;

public class Page<T>{
    private Integer offset;
    private Integer fetch;
    private Integer total;
    private List<T> results;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getFetch() {
        return fetch;
    }

    public void setFetch(Integer fetch) {
        this.fetch = fetch;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
