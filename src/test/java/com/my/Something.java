package com.my;

import com.alibaba.fastjson.JSON;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Test
    public void test2() {
        Object obj = null;
        String s = JSON.toJSONString(obj);
        System.out.println(s);
    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2017-11-02 10:02:25");
        long time = date.getTime();
        System.out.println(time);

    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long[] longs = {1510821067283L,1509611467283L,1512030667283L,1514449867283L,1513240267283L};
        for (int i = 0; i < longs.length; i++) {
            String format = simpleDateFormat.format(new Date(longs[i]));
            System.out.println(format);
        }

    }


}
