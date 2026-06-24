package com.hkwprince.springbootonlineshop.controller;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.dto.ProductQueryParams;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.service.ProductService;
import com.hkwprince.springbootonlineshop.dto.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        List<Product> productsList= productService.getProducts(productQueryParams);
        return  ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product!= null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){

        Integer productId= productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        // Check
        Product product = productService.getProductById(productId);
        if(product==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // Update
        productService.updateProduct(productId,productRequest);
        Product Updateproduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(Updateproduct);

    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
