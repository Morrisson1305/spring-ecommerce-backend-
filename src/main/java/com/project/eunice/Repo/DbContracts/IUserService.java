package com.project.eunice.Repo.DbContracts;
import com.project.eunice.Domain.Products;
import com.project.eunice.Domain.User;

import java.util.List;

public interface IUserService {

     User findUserById(Long userId);

     User findUserByEmail(String email);

     List<User> findAllUsers();

    List<Products> getCart(List<Long> productIds);

     User updateProfile(String email, User user);

//    Product addReviewToProduct(Reviews review, Long productId);
}
