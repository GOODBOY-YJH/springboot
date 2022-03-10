package com.example;

import com.example.Impl.BookDaoImpl;
import com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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


}
