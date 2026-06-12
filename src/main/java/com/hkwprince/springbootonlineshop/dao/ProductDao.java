package com.hkwprince.springbootonlineshop.dao;

import com.hkwprince.springbootonlineshop.model.Product;

public interface ProductDao {

    Product getProductById(Integer ProductId);
}
