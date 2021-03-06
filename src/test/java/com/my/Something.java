package com.my;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by wt on 2017/12/4.
 */
@SpringBootTest
public class Something {

    @Test
    public void test1() {
        Object obj = null;
        String s = JSON.toJSONString(obj);
        System.out.println(s);
    }
}
