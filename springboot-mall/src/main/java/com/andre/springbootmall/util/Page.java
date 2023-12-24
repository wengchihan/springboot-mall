package com.andre.springbootmall.util;

import java.util.List;

/**
 * ClassName: Page
 * Package: com.andre.springbootmall.util
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/24 - 19:02
 * @Version: v1.0
 */
public class Page<T> {

    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> results;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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
