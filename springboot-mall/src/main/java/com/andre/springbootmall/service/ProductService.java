package com.andre.springbootmall.service;

import com.andre.springbootmall.model.Product;

/**
 * ClassName: ProductService
 * Package: com.andre.springbootmall.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/15 - 11:31
 * @Version: v1.0
 */
public interface ProductService {

    Product getProductById(Integer productId);
}
