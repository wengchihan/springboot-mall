package com.andre.springbootmall.dao;

import com.andre.springbootmall.dto.UserRegisterRequest;
import com.andre.springbootmall.model.User;

/**
 * ClassName: UserDao
 * Package: com.andre.springbootmall.dao
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:30
 * @Version: v1.0
 */
public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
