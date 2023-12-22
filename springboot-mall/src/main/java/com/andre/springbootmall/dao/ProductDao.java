package com.andre.springbootmall.dao;


import com.andre.springbootmall.dto.ProductRequest;
import com.andre.springbootmall.model.Product;

/**
 * ClassName: ProductDao
 * Package: com.andre.springbootmall.dao
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/15 - 10:58
 * @Version: v1.0
 */
public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
