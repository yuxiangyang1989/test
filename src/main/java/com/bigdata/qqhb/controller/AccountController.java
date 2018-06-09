package com.bigdata.qqhb.controller;

import com.bigdata.apiout.ApiOut;
import com.bigdata.enums.ResponseCode;
import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Account;
import com.bigdata.qqhb.service.AccountService;
import com.bigdata.qqhb.vo.AccountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @ClassName: AccountController
 * @Description:客户信息
 * @date 2018-05-27
 * @version:
 */
@Slf4j
@RestController
@RequestMapping(value="/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ApiOut<Account>  info(@Valid AccountVo from, BindingResult bindingResult){
        log.info("新增客户或者查询客户信息!!!");
        if (bindingResult.hasErrors()) {
            log.info("[获取客户]参数不正确,ScoreForm={}",from);
            log.info("[获取客户]错误为{}",bindingResult.getFieldError().getDefaultMessage());
            return new ApiOut.Builder<Account>().data(null).code(ResponseCode.POST_DATA_FAIL).build();
        }
        Account account = accountService.info(from.getUserCode());
        return new ApiOut.Builder<Account>().data(account).code(ResponseCode.SUCCESS).build();
    }
    /**
     * 客户实名
     * @param userCode
     * @param userPhone
     * @param cardId
     * @return ApiOut
     */
    @GetMapping
    public ApiOut<String> supply(String userCode,String userPhone,String cardId){
        Account account = new Account();
        account.setCardId(cardId);
        account.setUserCode(userCode);
        account.setUserPhone(userPhone);

        boolean bl  = accountService.supply(account);
        if (bl){
            return new ApiOut.Builder<String>().data("实名认证成功").code(ResponseCode.SUCCESS).build();
        }
        return new ApiOut.Builder<String>().data("实名认证失败").code(ResponseCode.LOGIC_FAIL).build();


    }
}
