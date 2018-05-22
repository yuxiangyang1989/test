package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: AccountRepository
 * @Description:用户信息
 * @date 2018-05-22
 * @version:1.0.0
 */
public interface AccountRepository extends JpaRepository<Account,String> {
}
