package com.goooog.springboot.showcase.api;

import com.google.common.base.Preconditions;
import com.goooog.springboot.showcase.domain.User;
import com.goooog.springboot.showcase.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "用户相关接口")
@RequestMapping("/api/user")
public class UserEndpoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户", notes = "根据用户id查询用户详情")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        Preconditions.checkNotNull(userId, "user id not provided");
        Preconditions.checkArgument(userId > 0, "user id must greater than 0");

        return this.userService.getUser(userId);

    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        logger.info("User:{}", user);
    }

}
