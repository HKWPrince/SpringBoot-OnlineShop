package com.hkwprince.springbootonlineshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkwprince.springbootonlineshop.dao.UserDao;
import com.hkwprince.springbootonlineshop.dto.UserLoginRequest;
import com.hkwprince.springbootonlineshop.dto.UserRegisterRequest;
import com.hkwprince.springbootonlineshop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private  UserDao userDao;

//    Register
    @Test
    @Transactional
    void register_success() throws Exception {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("test@email.com");
        userRegisterRequest.setPassword("PassWord123");

        String jsonStr  = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.userId",notNullValue()))
                .andExpect(jsonPath("$.email",equalTo("test@email.com")))
                .andExpect(jsonPath("$.createdDate",notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate",notNullValue()));

        // Check if the password is encrypted
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        assertNotEquals(user.getPassword(),userRegisterRequest.getPassword());
    }

    @Test
    void register_invalidEmailFormat() throws Exception {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("testABC");
        userRegisterRequest.setPassword("PassWord123");

        String jsonStr  = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    @Test
    @Transactional
    void register_emailAlreadyExist() throws Exception {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("test@email.com");
        userRegisterRequest.setPassword("PassWord123");

        String jsonStr  = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }
//    Login

    @Test
    @Transactional
    void login_success() throws Exception {
    // Register new account
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("test@gmail.com");
        userRegisterRequest.setPassword("123");
        register(userRegisterRequest);
    // Login test
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail(userRegisterRequest.getEmail());
        userLoginRequest.setPassword(userRegisterRequest.getPassword());
        String jsonStrLogin = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrLogin);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.userId",notNullValue()))
                .andExpect(jsonPath("$.email",equalTo(userRegisterRequest.getEmail())))
                .andExpect(jsonPath("$.createdDate",notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate",notNullValue()));
    }

    @Test
    @Transactional
    void login_wrongPassword() throws Exception {
        // Register new account
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("test@gmail.com");
        userRegisterRequest.setPassword("123");
        register(userRegisterRequest);
        // Login test
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail(userRegisterRequest.getEmail());
        userLoginRequest.setPassword("testWrongPassword");
        String jsonStrLogin = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrLogin);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    @Test
    void login_invalidEmailFormat() throws Exception {

        // Login test
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("testWrongEmail");
        userLoginRequest.setPassword("testWrongPassword");
        String jsonStrLogin = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrLogin);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    @Test
    void login_emailNotExist() throws Exception {

        // Login test
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("test@mail.com");
        userLoginRequest.setPassword("testWrongPassword");
        String jsonStrLogin = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStrLogin);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    private  void register(UserRegisterRequest userRegisterRequest) throws Exception{

        String jsonStr = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }
}