package com.andre.springbootmall.dao.Impl;

import com.andre.springbootmall.dao.UserDao;
import com.andre.springbootmall.dto.UserRegisterRequest;
import com.andre.springbootmall.model.User;
import com.andre.springbootmall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: UserDaoImpl
 * Package: com.andre.springbootmall.dao.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:30
 * @Version: v1.0
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUserById(Integer userId) {

        String sql = "SELECT user_id, email, password, created_date, last_modified_date " +
                        "FROM user WHERE user_id = :userId";

        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {

        String sql = "INSERT INTO user(email, password, created_date, last_modified_date) " +
                "VALUES (:email, :password, :createdDate, :lastModifiedDate)";

        HashMap<String, Object> map = new HashMap<>();

        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());

        Date date = new Date();
        map.put("createdDate", date);
        map.put("lastModifiedDate",date);

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), generatedKeyHolder);

        int userId = generatedKeyHolder.getKey().intValue();

        return userId;
    }
}
