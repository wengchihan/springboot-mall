package com.andre.springbootmall.service.Impl;

import com.andre.springbootmall.constant.ProductCategory;
import com.andre.springbootmall.dao.ProductDao;
import com.andre.springbootmall.dto.ProductQueryParams;
import com.andre.springbootmall.dto.ProductRequest;
import com.andre.springbootmall.model.Product;
import com.andre.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
