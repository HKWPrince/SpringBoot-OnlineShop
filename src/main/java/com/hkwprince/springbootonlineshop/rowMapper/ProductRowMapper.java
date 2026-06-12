package com.hkwprince.springbootonlineshop.rowMapper;

import com.hkwprince.springbootonlineshop.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper  implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setCategory(rs.getString("category"));
        product.setImage_url(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setPrice(rs.getInt("stock"));
        product.setProduct_name(rs.getNString("description"));
        product.setCreated(rs.getDate("created"));
        product.setCreated(rs.getDate("last_modified_date"));


        return product;
    }
}
