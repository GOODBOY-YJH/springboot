package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟mvc调用
@AutoConfigureMockMvc
public class WebTest {
    @Test
    void test(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应请求
        mockMvc.perform(builder);

    }
    @Test
    void test1(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mockMvc.perform(builder);

        // 设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值成功状态200
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        action.andExpect(ok);


    }



}
