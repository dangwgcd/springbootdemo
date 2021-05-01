package com.my.tm;

import com.my.common.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by wt on 2017/12/8.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TmTest {
    @Autowired
    private BaseDao betaBaseDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private BaseDao tmpBaseDao;

    public void test() {
        List<Object> betaList = this.betaBaseDao.selectList("beta.sex");
        List<Object> tmpList = this.tmpBaseDao.selectList("tmp.sex");


    }

    @Test
    public void test1() {
        String redis_time_key = "tm_data_session_related_dev";
        Date startTime = new Date(Long.valueOf(stringRedisTemplate.opsForValue().get(redis_time_key)));
        System.out.println(startTime);
    }


    @Test
    public void test2() {
        System.out.println(String.valueOf(null));
    }


}
