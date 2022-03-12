package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Account;

import java.io.Serializable;

// Mybatis-Plus简化service
public interface IAccountService extends IService<Account> {
    IPage<Account> getPage(Integer currentPage, Integer pageSize, String name);
}
