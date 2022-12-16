package com.project.eunice.service;

import com.project.eunice.Domain.Products;
import com.project.eunice.Domain.User;
import com.project.eunice.Repo.DbContracts.IUserService;
import com.project.eunice.Repo.DbContracts.ProductRepo;
import com.project.eunice.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserService {
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Override
    public User findUserById(Long userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Products> getCart(List<Long> productIds) {
        return productRepo.findByIdIn(productIds);
    }

    @Override
    public User updateProfile(String email, User user) {
        User userFromDb = userRepo.findByEmail(email);
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setCity(user.getCity());
        userFromDb.setAddress(user.getAddress());
        userFromDb.setTelephone(user.getTelephone());
        userFromDb.setPostIndex(user.getPostIndex());
        userRepo.save(userFromDb);
        return userFromDb;
    }
}
