package com.hkwprince.springbootonlineshop.service.Implement;

import com.hkwprince.springbootonlineshop.dao.ProductDao;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer ProductId) {
        return productDao.getProductById(ProductId);
    }
}
