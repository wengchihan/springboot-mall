package com.andre.springbootmall.dao;

import com.andre.springbootmall.model.OrderItem;

import java.util.List;

/**
 * ClassName: OrderDao
 * Package: com.andre.springbootmall.dao
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 2:30
 * @Version: v1.0
 */
public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
