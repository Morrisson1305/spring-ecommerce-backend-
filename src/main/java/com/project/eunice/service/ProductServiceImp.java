package com.project.eunice.service;

import com.project.eunice.Domain.Products;
import com.project.eunice.Repo.DbContracts.IProductService;
import com.project.eunice.Repo.DbContracts.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService {

    private final ProductRepo productRepo;


    @Override
    public Products findProductById(Long productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public List<Products> findAllProducts() {
        return productRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Products> findProductByIds(List<Long> productId) {
        return productRepo.findByIdIn(productId);
    }

    @Override
    public List<Products> findByCategoryOrderByPriceDesc(String category) {
        return productRepo.findByCategoryOrderByPriceDesc(category);
    }

    @Override
    public Products saveProduct(Products product, MultipartFile file) {
        return productRepo.save(product);
    }

    @Override
    public List<Products> deleteProduct(Long productId) {
        return null;
    }


}
