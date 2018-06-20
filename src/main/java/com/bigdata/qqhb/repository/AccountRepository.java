package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: AccountRepository
 * @Description:用户信息
 * @date 2018-05-22
 * @version:1.0.0
 */
@Mapper
public interface AccountRepository extends IBaseRepository<Account,String> {
}
