package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.dto.UserRegisterRequest;
import com.hkwprince.springbootonlineshop.model.User;

public interface UserService {
    public Integer register(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);
}
