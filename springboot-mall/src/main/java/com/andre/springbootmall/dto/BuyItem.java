package com.andre.springbootmall.dto;

import jakarta.validation.constraints.NotNull;

/**
 * ClassName: BuyItem
 * Package: com.andre.springbootmall.dto
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 3:05
 * @Version: v1.0
 */
public class BuyItem {

    // 對應前端傳過來的2個key
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
