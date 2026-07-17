package com.hkwprince.springbootonlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper bjectMapper = new ObjectMapper();
    @Autowired
    private ObjectMapper objectMapper;


    //GetProduct

    @Test
    public void getProduct_success()throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/{productId}",1);
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(jsonPath("$.product_name",equalTo("iPhone 15 Pro")))
                .andExpect(jsonPath("$.category",equalTo("ELECTRONICS")))
                .andExpect(jsonPath("$.image_url", notNullValue()))
                .andExpect(jsonPath("$.price", notNullValue()))
                .andExpect(jsonPath("$.stock", notNullValue()))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.created", notNullValue()))
                .andExpect(jsonPath("$.last_modified_date", notNullValue()));
    }

    @Test
    public void getProduct_notFound() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/{productId}",10000);
        mockMvc.perform(requestBuilder).andExpect(status().is(404));
    }

    //CreateProduct
    @Transactional
    @Test
    public void creatProduct_success() throws Exception{

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_name("Test Product");
        productRequest.setCategory(ProductCategory.ELECTRONICS);
        productRequest.setImage_url("https://test.com");
        productRequest.setPrice(10);
        productRequest.setStock(0);

        String jsonObj = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201))
                .andDo(print())
                .andExpect(jsonPath("$.product_name",equalTo("Test Product")))
                .andExpect(jsonPath("$.category",equalTo("ELECTRONICS")))
                .andExpect(jsonPath("$.image_url", equalTo("https://test.com")))
                .andExpect(jsonPath("$.price", equalTo(10)))
                .andExpect(jsonPath("$.stock", equalTo(0)))
                .andExpect(jsonPath("$.description", nullValue()))
                .andExpect(jsonPath("$.created", notNullValue()))
                .andExpect(jsonPath("$.last_modified_date", notNullValue()));

    }

    @Transactional
    @Test
    public void creatProduct_illegalArgs() throws Exception{

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_name("Test Product");

        String jsonObj = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));

    }

    //UpdateProduct
    @Transactional
    @Test
    public void updateProduct_success() throws Exception{

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_name("Test Product");
        productRequest.setCategory(ProductCategory.ELECTRONICS);
        productRequest.setImage_url("https://test.com");
        productRequest.setPrice(10);
        productRequest.setStock(0);

        String jsonObj = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andDo(print())
                .andExpect(jsonPath("$.product_name",equalTo("Test Product")))
                .andExpect(jsonPath("$.category",equalTo("ELECTRONICS")))
                .andExpect(jsonPath("$.image_url", equalTo("https://test.com")))
                .andExpect(jsonPath("$.price", equalTo(10)))
                .andExpect(jsonPath("$.stock", equalTo(0)))
                .andExpect(jsonPath("$.description", nullValue()))
                .andExpect(jsonPath("$.created", notNullValue()))
                .andExpect(jsonPath("$.last_modified_date", notNullValue()));

    }

    @Transactional
    @Test
    public void updateProduct_illegalArgs() throws Exception{

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_name("Test Product");

        String jsonObj = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}",3)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));

    }

    @Transactional
    @Test
    public void updateProduct_notFound() throws Exception{

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_name("Test Product");
        productRequest.setCategory(ProductCategory.ELECTRONICS);
        productRequest.setImage_url("https://test.com");
        productRequest.setPrice(10);
        productRequest.setStock(0);

        String jsonObj = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}",10000)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));

    }

    // DeleteProduct
    @Transactional
    @Test
    public void deleteProduct_success() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}",1);

        mockMvc.perform(requestBuilder).andExpect(status().is(204));

    }

    @Transactional
    @Test
    public void deleteProduct_notFound() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}",10000);

        mockMvc.perform(requestBuilder).andExpect(status().is(204));

    }

    //Query Product

    @Test
    public void getProducts() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.offset",equalTo(0)))
                .andExpect(jsonPath("$.fetch",equalTo(0)))
                .andExpect(jsonPath("$.total", equalTo(30)))
                .andExpect(jsonPath("$.results", hasSize(30)));
    }

    @Test
    public void getProducts_filtering() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("category","ELECTRONICS")
                .param("search","iPhone");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.offset",equalTo(0)))
                .andExpect(jsonPath("$.fetch",equalTo(0)))
                .andExpect(jsonPath("$.total", equalTo(1)))
                .andExpect(jsonPath("$.results", hasSize(1)));
    }

    @Test
    public void getProducts_sorting() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("orderBy","product_id")
                .param("sort","Desc");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.offset",equalTo(0)))
                .andExpect(jsonPath("$.fetch",equalTo(0)))
                .andExpect(jsonPath("$.total", equalTo(30)))
                .andExpect(jsonPath("$.results[0].product_id", equalTo(30)))
                .andExpect(jsonPath("$.results[1].product_id", equalTo(29)))
                .andExpect(jsonPath("$.results[2].product_id", equalTo(28)))
                .andExpect(jsonPath("$.results[3].product_id", equalTo(27)));
    }

    @Test
    public void getProducts_pagination() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("offset","10")
                .param("fetch","10");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.offset",equalTo(10)))
                .andExpect(jsonPath("$.fetch",equalTo(10)))
                .andExpect(jsonPath("$.total", equalTo(30)))
                .andExpect(jsonPath("$.results", hasSize(10)));
    }



}