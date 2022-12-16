package com.project.eunice.controller;

import com.project.eunice.dto.product.ProductRequest;
import com.project.eunice.dto.product.ProductResponse;
import com.project.eunice.dto.user.UserResponse;
import com.project.eunice.exception.InputFieldException;
import com.project.eunice.mapper.ProductMapper;
import com.project.eunice.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/api/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    @PostMapping(value = "/add-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> addProduct(@RequestPart(name = "file", required = false) MultipartFile file,
                                                      @RequestPart("product") @Valid ProductRequest product,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(productMapper.saveProduct(product, file));
        }
    }

    @PatchMapping("/edit-product")
    public ResponseEntity<ProductResponse> updateProduct(@RequestPart(name = "file", required = false) MultipartFile file,
                                                         @RequestPart("product") @Valid ProductRequest product,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(productMapper.saveProduct(product, file));
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(userMapper.findUserById(userId));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userMapper.findAllUsers());
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<List<ProductResponse>> deleteProduct(@PathVariable(value = "productId") Long productId) {
        return ResponseEntity.ok(productMapper.deleteOrder(productId));
    }
}
