package com.andre.springbootmall.dto;

/**
 * ClassName: OrderQueryParams
 * Package: com.andre.springbootmall.dto
 * Description: 前端傳過來的請求參數
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 22:25
 * @Version: v1.0
 */
public class OrderQueryParams {

    private Integer userId;
    private Integer limit;
    private Integer offset;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
}
