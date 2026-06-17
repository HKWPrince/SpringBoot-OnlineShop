package com.hkwprince.springbootonlineshop.rowMapper;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
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
        product.setCategory(ProductCategory.valueOf(rs.getString("category").toUpperCase()));
        product.setImage_url(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.setDescription(rs.getNString("description"));
        product.setCreated(rs.getTimestamp("created"));
        product.setLast_modified_date(rs.getTimestamp("last_modified_date"));
        return product;
    }
}
