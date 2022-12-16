package com.project.eunice.controller;

import com.project.eunice.dto.product.ProductResponse;
import com.project.eunice.dto.product.ProductSearchRequest;
import com.project.eunice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductMapper productMapper;
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productMapper.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long productId) {
        return ResponseEntity.ok(productMapper.findProductById(productId));
    }

    @PostMapping("/ids")
    public ResponseEntity<List<ProductResponse>> getProductsByIds(@RequestBody List<Long> productsIds) {
        return ResponseEntity.ok(productMapper.findProductsByIds(productsIds));
    }


    @PostMapping("/search/category")
    public ResponseEntity<List<ProductResponse>> findByProductCategory(@RequestBody ProductSearchRequest filter) {
        return ResponseEntity.ok(productMapper.findByCategoryOrderByPriceDesc(filter.getCategory()));
    }
}
