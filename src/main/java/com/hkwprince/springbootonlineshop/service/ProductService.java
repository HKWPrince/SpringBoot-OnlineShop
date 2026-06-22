package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.model.Product;
import dto.ProductRequest;
import jakarta.validation.Valid;

public interface ProductService {
    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
