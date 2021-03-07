package com.my.controller;

import com.my.common.CommonJsonResult;
import com.my.entity.RedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wt on 2017/12/5.
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,RedisEntity> redisTemplate;

    @PostMapping(value = "setV")
    public CommonJsonResult setV() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();
        stringRedisTemplate.opsForValue().set("aaa","111");

        commonJsonResult.setSuccess("success");
        return commonJsonResult;
    }

    @GetMapping(value = "getV")
    public CommonJsonResult getV() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();
        String aaa = stringRedisTemplate.opsForValue().get("aaa");
        commonJsonResult.setInfoMap("aaa",aaa);

        return commonJsonResult;
    }

    @PostMapping(value = "setObjV")
    public CommonJsonResult setObjV() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        RedisEntity ld = new RedisEntity("ld", 28);
        redisTemplate.opsForValue().set(ld.getName(),ld);

        return commonJsonResult;
    }

    @GetMapping(value = "getObjV")
    public CommonJsonResult getObjV() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        RedisEntity ld = redisTemplate.opsForValue().get("ld");
        commonJsonResult.setInfoMap("ld",ld);

        return commonJsonResult;
    }
}
