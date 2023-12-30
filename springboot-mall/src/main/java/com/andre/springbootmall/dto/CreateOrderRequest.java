package com.andre.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * ClassName: CreateOrderRequest
 * Package: com.andre.springbootmall.dto
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 3:07
 * @Version: v1.0
 */
public class CreateOrderRequest {

    // 將前端傳過來的參數 轉換成 java class
    @NotEmpty
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
