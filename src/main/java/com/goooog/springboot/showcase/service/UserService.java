package com.goooog.springboot.showcase.service;

import com.goooog.springboot.showcase.core.base.AppException;
import com.goooog.springboot.showcase.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by young on 2017/9/17.
 */
@Service
public class UserService {

    public User getUser(Integer userId) {
        if (userId == 1) {
            throw new AppException(222, "not allowed to get user whose id equals 1");
        }
        User user = new User();
        user.setId(userId);
        user.setName("Name" + userId);
        return user;
    }

}
