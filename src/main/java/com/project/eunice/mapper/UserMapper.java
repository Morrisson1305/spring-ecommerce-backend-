package com.project.eunice.mapper;

import com.project.eunice.Domain.User;
import com.project.eunice.Repo.DbContracts.IUserService;
import com.project.eunice.dto.product.ProductResponse;
import com.project.eunice.dto.user.UserRequest;
import com.project.eunice.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.project.eunice.dto.RegistrationResquest;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final IUserService userService;
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    User convertToEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }

    User convertToEntity(RegistrationResquest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }


    UserResponse convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse findUserById(Long userId) {
        return convertToResponseDto(userService.findUserById(userId));
    }

    public UserResponse findUserByEmail(String email) {
        return convertToResponseDto(userService.findUserByEmail(email));
    }

    public UserResponse updateProfile(String email, UserRequest userRequest){
        return convertToResponseDto(userService.updateProfile(email, convertToEntity(userRequest)));
    }

    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getCart(List<Long> productIds){
        return productMapper.convertListToResponseDto(userService.getCart(productIds));
    }
}
