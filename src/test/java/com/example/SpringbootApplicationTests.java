package com.example;
import com.example.dao.AccountDao;
import com.example.dao.BookDao;
import com.example.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootApplication.class)
class SpringbootApplicationTests {

    // 注入要测试的对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println("test...");
        // 执行需要测试的对象方法
        bookDao.save();
    }


    @Autowired
    private AccountDao account;

    @Test
    void accountTest(){
        Account ac = account.selectById(1);
        System.out.println(ac);
        System.out.println(account.selectList(null));
    }



}
