package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Account;

/**
 * @author yang
 * @ClassName: AccountService
 * @Description:用户个人信息
 * @date 2018-05-24
 * @version:
 */
public interface AccountService {

    /**
     *新增客户信息或查询客户信息
     * @param userCode
     * @return Account
     * @throws Exception
     */
    public Account info(String userCode) throws SZBException;

    /**
     * 实名认证
     * @param account
     * @return
     * @throws Exception
     */
    public boolean supply(Account account)throws SZBException;
}
