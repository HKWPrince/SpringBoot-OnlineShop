package com.hkwprince.springbootonlineshop.dao.Implement;

import com.hkwprince.springbootonlineshop.dao.ProductDao;
import com.hkwprince.springbootonlineshop.dto.ProductQueryParams;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.rowMapper.ProductRowMapper;
import com.hkwprince.springbootonlineshop.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql  = "SELECT product_id,product_name, category, image_url, " +
                "price, stock, description, created, last_modified_date " +
                "From Product WHERE 1=1 ";

        Map<String, Object> map = new HashMap<>();
        //Filter
        if (productQueryParams.getCategory()!=null){
            sql = sql+" AND category = :category";
            map.put("category",productQueryParams.getCategory().name());
        }
        if (productQueryParams.getSearch()!=null){
            sql = sql+" AND product_name Like :search ";
            map.put("search", "%"+productQueryParams.getSearch()+"%");
        }
        //Sorting
        sql = sql + " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();
        //Pagination
        sql = sql + " OFFSET :offset  ROWS FETCH NEXT :fetch ROWS ONLY ";

        map.put("offset", productQueryParams.getOffest());
        map.put("fetch", productQueryParams.getFetch());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productList;

    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        String sql = "SELECT COUNT(*) FROM Product WHERE 1=1 ";
        Map<String, Object> map = new HashMap<>();
        //Filter
        if (productQueryParams.getCategory()!=null){
            sql = sql+" AND category = :category";
            map.put("category",productQueryParams.getCategory().name());
        }
        if (productQueryParams.getSearch()!=null){
            sql = sql+" AND product_name Like :search ";
            map.put("search", "%"+productQueryParams.getSearch()+"%");
        }

        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

    }

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

    @Override
    public Integer creatProduct(ProductRequest productRequest) {

        String sql = "INSERT INTO OnlineShop.dbo.Product " +
                "(product_name, category, image_url, price, stock, description, created, last_modified_date)" +
                "VALUES" +
                "(:product_name, :category, :image_url, :price, :stock, :description, :created, :last_modified_date)";

        Map<String,Object> map = new HashMap<>();
        map.put("product_name",productRequest.getProduct_name());
        map.put("category",productRequest.getCategory().toString());
        map.put("image_url",productRequest.getImage_url());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("created",now);
        map.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        String sql = "UPDATE Product " +
                        "SET " +
                            "product_name = :product_name, " +
                            "category = :category, " +
                            "image_url = :image_url, " +
                            "price = :price, " +
                            "stock = :stock, " +
                            "description = :description, " +
                            "last_modified_date = :last_modified_date " +
                            "WHERE product_id = :product_id";

        Map<String,Object> map = new HashMap<>();

        map.put("product_id",productId);

        map.put("product_name",productRequest.getProduct_name());
        map.put("category",productRequest.getCategory().toString());
        map.put("image_url",productRequest.getImage_url());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("last_modified_date", now);

        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "Delete Product " +
                "WHERE product_id = :product_id";

        Map<String,Object> map = new HashMap<>();
        map.put("product_id",productId);

        namedParameterJdbcTemplate.update(sql,map);

    }
}
