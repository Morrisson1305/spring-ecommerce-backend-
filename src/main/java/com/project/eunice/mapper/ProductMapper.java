package com.project.eunice.mapper;

import com.project.eunice.Domain.Products;
import com.project.eunice.Repo.DbContracts.IProductService;
import com.project.eunice.dto.product.ProductRequest;
import com.project.eunice.dto.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper modelMapper;
    private final IProductService productService;

    private Products convertToEntity(ProductRequest ProductRequest) {
        return modelMapper.map(ProductRequest, Products.class);
    }

    ProductResponse convertToResponseDto(Products Product) {
        return modelMapper.map(Product, ProductResponse.class);
    }

    List<ProductResponse> convertListToResponseDto(List<Products> Products) {
        return Products.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponse findProductById(Long productId) {
        return convertToResponseDto(productService.findProductById(productId));
    }

    public List<ProductResponse> findProductsByIds(List<Long> productsId) {
        return convertListToResponseDto(productService.findProductByIds(productsId));
    }

    public List<ProductResponse> findAllProducts() {
        return convertListToResponseDto(productService.findAllProducts());
    }


    public List<ProductResponse> findByCategoryOrderByPriceDesc(String categories) {
        return convertListToResponseDto(productService.findByCategoryOrderByPriceDesc(categories));
    }

    public ProductResponse saveProduct(ProductRequest productRequest, MultipartFile file) {
        return convertToResponseDto(productService.saveProduct(convertToEntity(productRequest), file));
    }

    public List<ProductResponse> deleteOrder(Long ProductId) {
        return convertListToResponseDto(productService.deleteProduct(ProductId));
    }


}
