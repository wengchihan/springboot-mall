package com.andre.springbootmall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * ClassName: UserRegisterRequest
 * Package: com.andre.springbootmall.dto
 * Description:  接收前端傳遞過來的,使用者的email and 密碼;
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:45
 * @Version: v1.0
 */
public class UserRegisterRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
