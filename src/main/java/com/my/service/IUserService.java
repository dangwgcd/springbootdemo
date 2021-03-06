package com.my.service;

import com.my.entity.User;

import java.util.List;

/**
 * Created by wt on 2017/12/4.
 */
public interface IUserService {

    public List<User> getUsers();

    User getUser(Integer id);
}
