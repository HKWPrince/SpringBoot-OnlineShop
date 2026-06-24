package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.model.Product;
import dto.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory productCategory, String search);

    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
