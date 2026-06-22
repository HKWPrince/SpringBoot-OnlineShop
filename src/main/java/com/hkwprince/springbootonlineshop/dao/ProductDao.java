package com.hkwprince.springbootonlineshop.dao;

import com.hkwprince.springbootonlineshop.model.Product;
import dto.ProductRequest;

public interface ProductDao {

    Product getProductById(Integer ProductId);

    Integer creatProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
