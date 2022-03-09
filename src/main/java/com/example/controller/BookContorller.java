package com.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest模式
@RestController
@RequestMapping("/books")
public class BookContorller {

    @GetMapping
    public String getById(){
        System.out.println("springBoot is running....");
        return "springBoot is running....";
    }


    @RequestMapping("/one")
    public String getById1(){
        System.out.println("springBoot is running....");
        return "springBoot is running....";
    }

}
