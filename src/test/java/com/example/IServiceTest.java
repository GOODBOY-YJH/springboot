package com.example;


import com.example.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IServiceTest {

    @Autowired
    private IAccountService iAccountService;

    @Test
    void testIService(){
        System.out.println(iAccountService.getById(1));
    }
}
