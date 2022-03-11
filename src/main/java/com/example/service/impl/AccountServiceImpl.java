package com.example.service.impl;

import com.example.dao.AccountDao;
import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public Boolean save(Account account) {
        return accountDao.insert(account) > 0;
    }

    @Override
    public Boolean update(Account account) {
        return accountDao.updateById(account) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return accountDao.deleteById(id) > 0;

    }

    @Override
    public Account getById(Integer id) {
        return accountDao.selectById(id);

    }

    @Override
    public List<Account> getAll() {
        return accountDao.selectList(null);

    }
}
