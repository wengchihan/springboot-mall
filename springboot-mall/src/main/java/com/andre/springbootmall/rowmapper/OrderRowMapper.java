package com.andre.springbootmall.rowmapper;

import com.andre.springbootmall.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: OrderRowMapper
 * Package: com.andre.springbootmall.rowmapper
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/31 - 17:20
 * @Version: v1.0
 */
public class OrderRowMapper implements RowMapper<Order> {


    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setUserId(rs.getInt("user_id"));
        order.setTotalAmount(rs.getInt("total_amount"));
        order.setCreatedDate(rs.getTimestamp("created_date"));
        order.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        return order;
    }
}
