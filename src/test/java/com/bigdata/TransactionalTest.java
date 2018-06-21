package com.bigdata;

import com.bigdata.szb.model.Statement;
import com.bigdata.szb.service.StatementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {

    @Autowired
    private StatementService statementService;

    @Test
    public void test(){
        Statement statement = new Statement();
        statement.setOpenid("1235679");
        statementService.modify(statement);
    }
}

