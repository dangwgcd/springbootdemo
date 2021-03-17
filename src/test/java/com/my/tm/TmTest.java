package com.my.tm;

import com.my.common.BaseDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wt on 2017/12/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TmTest {
    @Autowired
    private BaseDao betaBaseDao;

    @Autowired
    private BaseDao tmpBaseDao;

    public void test() {
        List<Object> betaList = this.betaBaseDao.selectList("beta.sex");
        List<Object> tmpList = this.tmpBaseDao.selectList("tmp.sex");


    }


}
