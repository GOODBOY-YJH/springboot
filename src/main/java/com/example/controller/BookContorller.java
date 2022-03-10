package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest模式
@RestController
@RequestMapping("/books")
public class BookContorller {

    // 读取ymal数据中的单一数据

    @Value("${country}")
    private String country;

    @Value("${user1.name}")
    private String name;

    @Value("${likes[1]}")
    private String like;

    @Value("${users[1].name}")
    private String usersName;

    @Value("${tempDir}")
    private String tempDir;

    // 使用自动装配将所有的数据封装到一个对象environment中

    @Autowired
    private Environment environment;

    @GetMapping
    public String getById(){
        System.out.println("springBoot is running...." + environment.getProperty("user1.name"));
        return "springBoot is running....";
    }


    @RequestMapping("/one")
    public String getById1(){
        System.out.println("springBoot is running...."+ country + " " + name + " " + like + " " + usersName+ " " + tempDir);
        return "springBoot is running....";
    }






}
