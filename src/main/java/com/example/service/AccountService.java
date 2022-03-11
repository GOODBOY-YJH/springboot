package com.example.service;

import com.example.domain.Account;

import java.awt.print.Book;
import java.util.List;

public interface AccountService {
    Boolean save(Account account);
    Boolean update(Account account);
    Boolean delete(Integer id);
    Account getById(Integer id);
    List<Account> getAll();
}
