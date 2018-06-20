package com.bigdata.qqhb.service.impl;

import com.bigdata.framework.db.condition.QueryCondition;
import com.bigdata.qqhb.condition.AccountQueryCondition;
import com.bigdata.qqhb.model.Account;
import com.bigdata.qqhb.repository.AccountRepository;
import com.bigdata.qqhb.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author yang
 * @ClassName: AccountServiceImpl
 * @Description:
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account info(String userCode) {
        Account account = new Account();
        account.setUserCode(userCode);
        AccountQueryCondition condition = new AccountQueryCondition();
        condition.setAccount(account);
        //存在即返回, 无则提供默认值
        Account relust = accountRepository.findOne(condition);
        if (null!= relust)
        return relust;
        accountRepository.create(account);
        return null;
    }

    @Override
    public boolean supply(Account account){;
        return Optional.of(accountRepository.create(account)).isPresent();
    }
}
