package com.hkwprince.springbootonlineshop.dao.Implement;

import com.hkwprince.springbootonlineshop.dao.UserDao;
import com.hkwprince.springbootonlineshop.dto.UserRegisterRequest;
import com.hkwprince.springbootonlineshop.model.User;
import com.hkwprince.springbootonlineshop.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {

        String sql = "INSERT into Users " +
                "(email, password, created_date, last_modified_date) VALUES " +
                " (:email, :password, :createDate, :lastModifiedDate)";

        Map<String,Object> map = new HashMap<>();

        map.put("email",userRegisterRequest.getEmail());
        map.put("password",userRegisterRequest.getPassword());

        Date date = new Date();

        map.put("createDate",date);
        map.put("lastModifiedDate",date);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        return  keyHolder.getKey().intValue();
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "SELECT user_id, email, password, created_date, last_modified_date FROM Users WHERE user_id = :userId";

        Map<String,Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> usersList = namedParameterJdbcTemplate.query(sql,map, new UserRowMapper());

        if (usersList.size()>0)
            return usersList.get(0);

        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT user_id, email, password, created_date, last_modified_date " +
                        "FROM Users WHERE email = :email";
        Map<String,Object> map = new HashMap<>();
        map.put("email", email);

        List<User> userList = namedParameterJdbcTemplate.query(sql,map, new UserRowMapper());

        if (userList.size()>0)
            return userList.get(0);

        return null;

    }
}
