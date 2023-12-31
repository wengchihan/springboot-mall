package com.andre.springbootmall.service;

import com.andre.springbootmall.dto.CreateOrderRequest;
import com.andre.springbootmall.dto.OrderQueryParams;
import com.andre.springbootmall.model.Order;

import java.util.List;

/**
 * ClassName: OrderService
 * Package: com.andre.springbootmall.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 2:32
 * @Version: v1.0
 */
public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
