package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.AccountDao;
import com.example.domain.Account;
import com.example.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceIpl extends ServiceImpl<AccountDao, Account> implements IAccountService {
}
