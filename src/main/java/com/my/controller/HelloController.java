package com.my.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wt on 2017/10/11.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String test() {
        return "hello,springbootdemo!";
    }
}
