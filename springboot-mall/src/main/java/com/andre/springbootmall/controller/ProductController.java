package com.andre.springbootmall.controller;

import com.andre.springbootmall.constant.ProductCategory;
import com.andre.springbootmall.dto.ProductQueryParams;
import com.andre.springbootmall.dto.ProductRequest;
import com.andre.springbootmall.model.Product;
import com.andre.springbootmall.service.ProductService;
import com.andre.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: ProductController
 * Package: com.andre.springbootmall.controller
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/15 - 11:36
 * @Version: v1.0
 */
@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @param category 前端傳來的參數 - 目錄
     * @param search 前端傳來的參數 - search欄位(用戶輸入的查詢內容)
     * @param orderBy 根據什麼樣的欄位進行排序
     * @param sort 升序 or 降序 排序
     * @RequestParam(required = false) 前端有沒有傳遞這個參數 api都可以執行
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            // 排序 Sorting - 控制商品數據的排序
            @RequestParam(defaultValue = "created_date") String orderBy, // 預設 商品的創建時間
            @RequestParam(defaultValue = "desc") String sort, // 預設 降序 - 大 到 小
            // 分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
            ) {

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // 取得 product list
        List<Product> productList = productService.getProducts(productQueryParams);

        // 取得 product 總數
        Integer total = productService.countProduct(productQueryParams);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);


        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 新增商品
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    // 修改商品
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {
        // 查詢商品是否存在
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // 商品如果存在 => 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
