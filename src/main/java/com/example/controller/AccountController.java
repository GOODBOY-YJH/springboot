package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        boolean flag = accountService.save(account);
        return new R(flag, flag == true ? "添加成功^_^":"添加失败#_#");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(accountService.removeById(id));
    }
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, accountService.getById(id));
    }
    @PutMapping
    public R getById(@RequestBody Account account){
        return new R(true, accountService.updateById(account));
    }

    // @GetMapping("/{currentPage}/{pageSize}")
    // public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
    //     IPage<Account> page = new Page(currentPage, pageSize);
    //     // 如果当前页码值大于了总页码值 那么重新执行查询操作 使用最大页码值作为当前页码值
    //     return new R(true, accountService.page(page, null));
    // }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize, String name){
        System.out.println("笨比");
        IPage<Account> page = accountService.getPage(currentPage, pageSize, name);
        // 如果当前页码值大于了总页码值 那么重新执行查询操作 使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = accountService.getPage((int) page.getPages(), pageSize, name);
        }
        return new R(true,page);
    }
}
