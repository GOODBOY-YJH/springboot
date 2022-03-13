package com.example;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.AccountDao;
import com.example.dao.BookDao;
import com.example.domain.Account;
import com.example.testcase.domain.AccountTest;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = SpringbootApplication.class)
@Transactional
@Rollback(value = true)
class SpringbootApplicationTests {

    // 注入要测试的对象
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountTest accountTest;

    @Test
    void test(){
        System.out.println(accountTest);
    }

    @Test
    void contextLoads() {
        System.out.println("test...");
        // 执行需要测试的对象方法
        bookDao.save();
    }


    @Autowired
    private AccountDao account;

    @Test
    void accountGet(){
        Account ac = account.selectById(1);
        System.out.println(ac);
        System.out.println(account.selectList(null));
    }

    @Test
    void accountSave(){
        Account ac = new Account();
        ac.setName("aaa3");
        ac.setMoney(10000);
        account.insert(ac);
    }
    @Test
    void accountUpdate(){
        Account ac = new Account();
        ac.setId(3);
        ac.setName("aaa");
        ac.setMoney(10000);
        account.updateById(ac);
    }

    @Test
    void accountDelete(){
        account.deleteById(3);
    }

    @Test
    void accountGetAll(){
        List<Account> accounts = account.selectList(null);
    }

    @Test
    void accountPage(){
        IPage page = new Page(1, 5);
        account.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void accountGetBy(){
        QueryWrapper<Account> qw = new QueryWrapper<>();
        qw.like("name", "zhangsan");
        List<Account> accounts = account.selectList(qw);
    }

    @Test
    void accountGetBy2(){
        String name = "zhangsan";
        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<>();
        // lqw.like(Account::getName, name);
        lqw.like(Strings.isNotEmpty(name), Account::getName, name);
        List<Account> accounts = account.selectList(lqw);
    }

}
