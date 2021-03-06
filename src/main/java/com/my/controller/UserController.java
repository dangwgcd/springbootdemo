package com.my.controller;

import com.my.common.CommonJsonResult;
import com.my.config.properties.UserProperties;
import com.my.entity.User;
import com.my.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wt on 2017/12/4.
 */
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

    @GetMapping(value = "get_user")
    public CommonJsonResult test1() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        User user = new User(name, age);
        commonJsonResult.setInfoMap("user", user);
        commonJsonResult.setInfoMap("userProperties", userProperties);

        return commonJsonResult;
    }

    @GetMapping(value = "users")
    public CommonJsonResult users() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        List<User> users = userService.getUsers();
        commonJsonResult.setResultList(users);

        return commonJsonResult;
    }


    @GetMapping(value = "userById")
    public CommonJsonResult users(@RequestParam(required = true) Integer id) {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        User user = userService.getUser(id);
        commonJsonResult.setInfoMap("user",user);

        return commonJsonResult;
    }


}
