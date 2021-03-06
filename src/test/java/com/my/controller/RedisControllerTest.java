package com.my.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by wt on 2017/12/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RedisControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void setV() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/setV/");
        mvc.perform(requestBuilder);
    }

    @Test
    public void getV() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/getV/");
        mvc.perform(requestBuilder);
    }

    @Test
    public void setObjV() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/setObjV/");
        mvc.perform(requestBuilder);
    }

    @Test
    public void getObjV() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/getObjV/");
        mvc.perform(requestBuilder);
    }

}