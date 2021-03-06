package com.my.service.impl;

import com.my.config.BaseDao;
import com.my.entity.User;
import com.my.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wt on 2017/12/4.
 */
@Service
@Transactional(transactionManager = "betaTransactionManager", readOnly = false, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {
    @Autowired
    private BaseDao betaBaseDao;

    @Override
    public List<User> getUsers() {
        return betaBaseDao.selectList("UserMapper.getUsers");
    }

    @Override
    public User getUser(Integer id) {
        return betaBaseDao.selectOne("UserMapper.getUser",id);
    }
}
