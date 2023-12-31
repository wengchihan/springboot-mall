package com.andre.springbootmall.service.Impl;

import com.andre.springbootmall.dao.OrderDao;
import com.andre.springbootmall.dao.ProductDao;
import com.andre.springbootmall.dto.BuyItem;
import com.andre.springbootmall.dto.CreateOrderRequest;
import com.andre.springbootmall.model.Order;
import com.andre.springbootmall.model.OrderItem;
import com.andre.springbootmall.model.Product;
import com.andre.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrderServiceImpl
 * Package: com.andre.springbootmall.service.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 2:32
 * @Version: v1.0
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        // 透過 orderId, 在 order table 中 查出這筆訂單總資訊
        Order order = orderDao.getOrderById(orderId);
        // 透過 orderId, 在 orderItems table 中
        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order; // 除了包含訂單總資訊外,也會包含這筆訂單分別購買哪些商品的資訊

    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());
            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
