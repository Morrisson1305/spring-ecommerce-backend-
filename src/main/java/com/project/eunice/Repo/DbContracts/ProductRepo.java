package com.project.eunice.Repo.DbContracts;

import com.project.eunice.Domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {

    List<Products> findAllByOrderByIdAsc();

    List<Products> findByCategoryIn(List<String> category);


    List<Products> findByCategoryOrderByPriceDesc(String category);

    List<Products> findByIdIn(List<Long> productsIds);
}
