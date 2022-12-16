package com.project.eunice.service;

import com.project.eunice.Domain.User;
import com.project.eunice.Repo.DbContracts.IAuthService;

import java.util.Map;

public class AuthServiceImp implements IAuthService {

    @Override
    public Map<String, String> login(String email, String password) {
        return null;
    }

    @Override
    public String registerUser(User user, String password2) {
        return null;
    }

    @Override
    public String activateUser(String code) {
        return null;
    }

    @Override
    public User findByPasswordResetCode(String code) {
        return null;
    }

    @Override
    public String sendPasswordResetCode(String email) {
        return null;
    }

    @Override
    public String passwordReset(String email, String password, String password2) {
        return null;
    }
}
