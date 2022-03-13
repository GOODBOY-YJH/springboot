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
import org.springframework.test.web.servlet.result.ContentResultMatchers;
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
        // 定义本次调用的预期值（可以选择content等等）成功状态200
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        action.andExpect(ok);


    }

    @Test
    void test2(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/accounts");
        ResultActions action = mockMvc.perform(builder);

        // 设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        // 匹配json
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\n" +
                "  \"flag\": true,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"zhangsan\",\n" +
                "      \"money\": 1000000.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"lisi\",\n" +
                "      \"money\": 2345.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"wngwu\",\n" +
                "      \"money\": 10000.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"name\": \"where 1==1\",\n" +
                "      \"money\": 6654343.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"name\": \"aa\",\n" +
                "      \"money\": 6654343.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"name\": \"aa\",\n" +
                "      \"money\": 6654343.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 8,\n" +
                "      \"name\": \"aa\",\n" +
                "      \"money\": 6654343.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 9,\n" +
                "      \"name\": \"aa\",\n" +
                "      \"money\": 6654343.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 15,\n" +
                "      \"name\": \"dsafds\",\n" +
                "      \"money\": 0.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 16,\n" +
                "      \"name\": \"fgdsagsf\",\n" +
                "      \"money\": 25436.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 26,\n" +
                "      \"name\": \"aaa\",\n" +
                "      \"money\": 10000.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 27,\n" +
                "      \"name\": \"dsafad\",\n" +
                "      \"money\": 3214516.0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"msg\": null\n" +
                "}");

        action.andExpect(json);
    }



}
