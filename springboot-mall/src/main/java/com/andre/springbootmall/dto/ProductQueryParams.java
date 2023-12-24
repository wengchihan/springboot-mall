package com.andre.springbootmall.dto;

import com.andre.springbootmall.constant.ProductCategory;

/**
 * ClassName: ProductQueryParams
 * Package: com.andre.springbootmall.dto
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/24 - 14:23
 * @Version: v1.0
 */
public class ProductQueryParams {

    private ProductCategory category;
    private String search;
    private String orderBy;
    private String sort;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
