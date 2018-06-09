package com.bigdata.qqhb.service.impl;

import com.bigdata.qqhb.model.Account;
import com.bigdata.qqhb.repository.AccountRepository;
import com.bigdata.qqhb.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        //ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("userCode", ExampleMatcher.GenericPropertyMatchers.regex()).withIgnorePaths("focus");
        Example<Account> example = Example.of(account/*,matcher*/);
        //存在即返回, 无则提供默认值
        return accountRepository.findOne(example).orElseGet(()->accountRepository.save(account));
    }

    @Override
    public boolean supply(Account account){;
        return Optional.of(accountRepository.save(account)).isPresent();
    }
}
