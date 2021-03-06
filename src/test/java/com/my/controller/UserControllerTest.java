package com.my.controller;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wt on 2017/12/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
//    }

    @Test
    public void users() throws Exception {
        RequestBuilder requestBuilder = get("/users");
//        mvc.perform(requestBuilder).andExpect(status().isOk());
        mvc.perform(requestBuilder);
    }

    @Test
    public void users1() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/userById/").param("id", "48");
        mvc.perform(requestBuilder);
    }

}