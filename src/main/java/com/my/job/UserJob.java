package com.my.job;

import com.alibaba.fastjson.JSON;
import com.my.entity.User;
import com.my.service.IUserService;
import com.my.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wt on 2017/12/12.
 */
public class UserJob {

    private Logger logger = LoggerFactory.getLogger(UserJob.class);

    @Autowired
    private IUserService userService;

    public void getUserById() {
        User user = this.userService.getUser(1);
        logger.info("查询时间：{}", DateUtil.getNowDate());
        logger.info(JSON.toJSONString(user));

    }
}
