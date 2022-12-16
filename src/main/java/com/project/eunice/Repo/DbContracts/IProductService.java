package com.project.eunice.Repo.DbContracts;

import com.project.eunice.Domain.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {


    Products findProductById(Long productId);

    List<Products> findAllProducts();

    List<Products> findProductByIds(List<Long> productId);


    List<Products> findByCategoryOrderByPriceDesc(String category);

    Products saveProduct(Products product, MultipartFile file);

    List<Products> deleteProduct(Long productId);
}
