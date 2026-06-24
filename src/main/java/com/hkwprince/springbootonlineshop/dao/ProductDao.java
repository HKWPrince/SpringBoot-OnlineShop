package com.hkwprince.springbootonlineshop.dao;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.model.Product;
import dto.ProductRequest;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory productCategory, String search);

    Product getProductById(Integer ProductId);

    Integer creatProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
