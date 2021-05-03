package com.my;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.my.common.CommonJsonResult;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.chrono.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springfox.documentation.spring.web.json.Json;

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
        Long[] longs = {1510821067283L, 1509611467283L, 1512030667283L, 1514449867283L, 1513240267283L};
        for (int i = 0; i < longs.length; i++) {
            String format = simpleDateFormat.format(new Date(longs[i]));
            System.out.println(format);
        }

    }


    @Test
    public void test5() throws ParseException {
        CommonJsonResult commonJsonResult = new CommonJsonResult();
        commonJsonResult.setResultList(Lists.newArrayList("13147119605", "13810315896", "15861684221"));

        System.out.println(JSON.toJSONString(commonJsonResult));

    }

    @Test
    public void test6() throws ParseException {

        Date start = new LocalDate(2016, 2, 8).toDate();
        Date end = new LocalDate(2017, 1, 27).toDate();

        Integer days = Days.daysBetween(new DateTime(start), new DateTime(end)).getDays();
        System.out.println(days);

    }

    @Test
    public void test7() throws ParseException {
        Date start = new LocalDate(2017, 1, 28).toDate();
        Date end = new LocalDate(2017, 1, 29).toDate();


        Integer days = Days.daysBetween(new DateTime(start), new DateTime(end)).getDays();
        System.out.println(days);

        new DateTime().isAfterNow();

    }

    @Test
    public void test8() throws ParseException {
        String[] strings = PinyinHelper.toHanyuPinyinStringArray('王');
        System.out.println(strings);

    }


}
