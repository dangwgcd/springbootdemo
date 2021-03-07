package com.my.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wt on 2017/10/11.
 */
@Api(tags = "helloWorld测试")
@RestController
public class HelloController {
    @GetMapping("/")
    @ApiOperation(value = "连接测试")
    public String test() {
//        return "hello,springbootdemo!ld-wt";
        return "hello,springbootdemo!ld";
    }
}
