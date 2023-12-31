package com.andre.springbootmall.dao;

import com.andre.springbootmall.dto.OrderQueryParams;
import com.andre.springbootmall.model.Order;
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

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    // 透過 orderId, 在 order table 中 查出這筆訂單總資訊
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
