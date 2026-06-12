package com.hkwprince.springbootonlineshop.dao.Implement;

import com.hkwprince.springbootonlineshop.dao.ProductDao;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.rowMapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ProdcutDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Product getProductById(Integer productId) {
        String sql  = "SELECT product_id,product_name, category, image_url, " +
                        "price, stock, description, created, last_modified_date " +
                        "From Product " +
                        "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList.size()>0){
            return productList.get(0);
        }

        return null;
    }
}
