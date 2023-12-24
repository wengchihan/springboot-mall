package com.andre.springbootmall.service;


import com.andre.springbootmall.dto.ProductQueryParams;
import com.andre.springbootmall.dto.ProductRequest;
import com.andre.springbootmall.model.Product;

import java.util.List;

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

    // 假如有N個查詢條件,就要一直添加,不利於程式的維護; 改善的方法:創建一個class,在裡面去存放這些參數的值,最後再傳遞過去
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
