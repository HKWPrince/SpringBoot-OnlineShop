package com.hkwprince.springbootonlineshop.dao;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.dto.ProductQueryParams;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.dto.ProductRequest;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer ProductId);

    Integer creatProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    Integer countProduct(ProductQueryParams productQueryParams);
}
