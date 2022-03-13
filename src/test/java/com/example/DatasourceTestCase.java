package com.example;

import com.example.config.MsgConfig;
import com.example.domain.MyDateSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

// properties args 属性可以给测试添加临时的属性配置

// @SpringBootTest(properties = {"键=值"})
@SpringBootTest//(args = {"--键=值"})
@Import(MsgConfig.class) // 加载额外配置类
public class DatasourceTestCase {

    @Autowired
    private MyDateSource myDateSource;

    @Autowired
    private String msg;

    @Test
    void testGetById() {
        System.out.println(myDateSource.getUrl());
        System.out.println(msg);
    }
}
