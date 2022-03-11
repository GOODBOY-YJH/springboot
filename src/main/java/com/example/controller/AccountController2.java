package com.example.controller;


import com.example.domain.Account;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping("/accounts")
public class AccountController2 {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Account account){
        return accountService.save(account);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return accountService.removeById(id);
    }

    @GetMapping("{id}")
    public Account getById(@PathVariable Integer id){
        return accountService.getById(id);
    }

}
