package com.andre.springbootmall.service;

import com.andre.springbootmall.dto.UserRegisterRequest;
import com.andre.springbootmall.model.User;

/**
 * ClassName: UserService
 * Package: com.andre.springbootmall.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:40
 * @Version: v1.0
 */
public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
