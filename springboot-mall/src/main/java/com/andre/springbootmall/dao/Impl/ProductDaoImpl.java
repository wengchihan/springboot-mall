package com.andre.springbootmall.dao.Impl;

import com.andre.springbootmall.dao.ProductDao;
import com.andre.springbootmall.model.Product;
import com.andre.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName: ProductDaoImpl
 * Package: com.andre.springbootmall.dao.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/15 - 10:59
 * @Version: v1.0
 */
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 透過productId 去查詢商品
     *
     * @param productId
     * @return
     */
    @Override
    public Product getProductById(Integer productId) {

        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";

        HashMap<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }

    }
}
