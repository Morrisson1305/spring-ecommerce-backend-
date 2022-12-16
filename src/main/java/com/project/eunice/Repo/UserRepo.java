package com.project.eunice.Repo;

import com.project.eunice.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByOrderByIdAsc();

    User findByActivationCode(String code);

    User findByEmail(String email);

    User findByPasswordResetCode(String code);
}
