package com.project.eunice.Repo.DbContracts;
import com.project.eunice.Domain.User;

import java.util.Map;

public interface IAuthService {

    Map<String, String> login(String email, String password);

    String registerUser(User user, String password2);

    String activateUser(String code);

    User findByPasswordResetCode(String code);

    String sendPasswordResetCode(String email);

    String passwordReset(String email, String password, String password2);
}
