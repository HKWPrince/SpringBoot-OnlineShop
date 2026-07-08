package com.hkwprince.springbootonlineshop.controller;

import com.hkwprince.springbootonlineshop.Constant.ProductCategory;
import com.hkwprince.springbootonlineshop.dto.ProductQueryParams;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.service.ProductService;
import com.hkwprince.springbootonlineshop.dto.ProductRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hkwprince.springbootonlineshop.util.Page;

import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<Page<Product>> getProducts(
            //Filter
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            // Sorting
            @RequestParam(defaultValue = "created") String orderBy,
            @RequestParam(defaultValue = "asc") String sort,
            //Pagination
            @RequestParam(defaultValue = "0") @Max(1000) @Min(0) Integer offset,
            @RequestParam(defaultValue = "1") @Min(1) Integer fetch

    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setOffest(offset);
        productQueryParams.setFetch(fetch);

//      Get Product list
        List<Product> productsList = productService.getProducts(productQueryParams);
//      Get Product number
        Integer total = productService.countProduct(productQueryParams);
//      Paginate
        Page<Product> page = new Page<>();
        page.setOffset(offset);
        page.setFetch(fetch);
        page.setTotal(total);
        page.setResults(productsList);

        return  ResponseEntity.status(HttpStatus.OK).body(page);
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
