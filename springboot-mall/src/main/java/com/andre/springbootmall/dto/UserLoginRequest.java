package com.andre.springbootmall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * ClassName: UserLoginRequest
 * Package: com.andre.springbootmall.dto
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/27 - 15:48
 * @Version: v1.0
 */
public class UserLoginRequest {
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
