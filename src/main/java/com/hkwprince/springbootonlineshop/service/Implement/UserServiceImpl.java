package com.hkwprince.springbootonlineshop.service.Implement;

import com.hkwprince.springbootonlineshop.dao.UserDao;
import com.hkwprince.springbootonlineshop.dto.UserRegisterRequest;
import com.hkwprince.springbootonlineshop.model.User;
import com.hkwprince.springbootonlineshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public Integer register(UserRegisterRequest userRegisterRequest){
        // Check E-mail
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user!=null){
            log.warn("The E-mail, {} has been registered",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //  Create Account
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }


}
