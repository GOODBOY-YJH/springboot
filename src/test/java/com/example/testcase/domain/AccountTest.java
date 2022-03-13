package com.example.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "testcase.account")
public class AccountTest {
    private Integer id;
    private Integer id2;
    private String name;
    private double money;
}
