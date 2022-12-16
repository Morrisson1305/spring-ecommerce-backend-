package com.project.eunice.security;

import com.project.eunice.Domain.User;
import com.project.eunice.Repo.DbContracts.IUserService;
import com.project.eunice.exception.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {


    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if (user.getActivationCode() != null) {
            throw new LockedException("email not activated");
        }
        return UserPrincipal.create(user);
    }

}
