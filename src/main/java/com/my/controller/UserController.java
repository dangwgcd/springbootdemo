package com.my.controller;

import com.my.common.CommonJsonResult;
import com.my.config.properties.UserProperties;
import com.my.entity.User;
import com.my.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by wt on 2017/12/4.
 */
@Api(tags = "用户管理")
@RestController
public class UserController {
    @Value("${user1.name}")
    private String name;

    @Value("${user1.age}")
    private Integer age;

    @Value("${user1.content}")
    private String content;

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private IUserService userService;

    @ApiIgnore
    @GetMapping(value = "get_user")
    public CommonJsonResult test1() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        User user = new User(name, age);
        commonJsonResult.setInfoMap("user", user);
        commonJsonResult.setInfoMap("userProperties", userProperties);

        return commonJsonResult;
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping(value = "users")
    public CommonJsonResult users() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        List<User> users = userService.getUsers();
        commonJsonResult.setResultList(users);

        return commonJsonResult;
    }


    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping(value = "userById")
    public CommonJsonResult users(@ApiParam("用户id") @RequestParam(required = true) Integer id) {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        User user = userService.getUser(id);
        commonJsonResult.setInfoMap("user", user);

        return commonJsonResult;
    }


}
