package com.example.controller;


import com.example.controller.utils.R;
import com.example.domain.Account;
import com.example.service.IAccountService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping
    public R getAll(){
        return new R(true, accountService.list());
    }

    @PostMapping
    public R save(@RequestBody Account account){
        return new R(accountService.save(account));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(accountService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, accountService.getById(id));
    }

}
