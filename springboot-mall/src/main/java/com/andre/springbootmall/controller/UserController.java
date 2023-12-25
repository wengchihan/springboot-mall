package com.andre.springbootmall.controller;

import com.andre.springbootmall.dto.UserRegisterRequest;
import com.andre.springbootmall.model.User;
import com.andre.springbootmall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: com.andre.springbootmall.controller
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:41
 * @Version: v1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }





}
