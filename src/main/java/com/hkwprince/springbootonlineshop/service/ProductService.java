package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.model.Product;
import dto.ProductRequest;

public interface ProductService {
    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
