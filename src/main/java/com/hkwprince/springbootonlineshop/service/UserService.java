package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.dto.UserLoginRequest;
import com.hkwprince.springbootonlineshop.dto.UserRegisterRequest;
import com.hkwprince.springbootonlineshop.model.User;
import jakarta.validation.Valid;

public interface UserService {
    public Integer register(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);

    User login(@Valid UserLoginRequest userLoginRequest);
}
