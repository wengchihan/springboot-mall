package com.andre.springbootmall.service.Impl;


import com.andre.springbootmall.dao.UserDao;
import com.andre.springbootmall.dto.UserLoginRequest;
import com.andre.springbootmall.dto.UserRegisterRequest;
import com.andre.springbootmall.model.User;
import com.andre.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * ClassName: UserServiceImpl
 * Package: com.andre.springbootmall.service.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2023/12/25 - 22:40
 * @Version: v1.0
 */
@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        // 當 user != null 表明 這個email已經註冊過帳號, 報 400錯誤
        if (user != null) {
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        // 需要檢查 使用者所輸入的 帳號密碼 是否和資料庫的一致
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user == null) {
            // email 不存在
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (user.getPassword().equals(userLoginRequest.getPassword())) {
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
