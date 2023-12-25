package com.andre.springbootmall.rowmapper;

import com.andre.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: UserRowMapper
 * Package: com.andre.springbootmall.rowmapper
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 23:20
 * @Version: v1.0
 */
public class UserRowMapper implements RowMapper<User> {


    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setCreatedDate(resultSet.getTimestamp("created_date"));
        user.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return user;
    }

}
