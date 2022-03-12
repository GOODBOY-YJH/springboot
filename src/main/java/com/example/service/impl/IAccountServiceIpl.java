package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.AccountDao;
import com.example.domain.Account;
import com.example.service.IAccountService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceIpl extends ServiceImpl<AccountDao, Account> implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public IPage<Account> getPage(Integer currentPage, Integer pageSize, String name) {
        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<Account>();
        lqw.like(Strings.isNotEmpty(name), Account::getName, name);
        IPage<Account> page = new Page<>(currentPage, pageSize);
        accountDao.selectPage(page, lqw);
        return page;
    }
}
