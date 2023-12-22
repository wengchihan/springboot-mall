package com.andre.springbootmall.service.Impl;

import com.andre.springbootmall.dao.ProductDao;
import com.andre.springbootmall.model.Product;
import com.andre.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: ProductServiceImpl
 * Package: com.andre.springbootmall.service.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/15 - 11:32
 * @Version: v1.0
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}