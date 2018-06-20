package com.bigdata.qqhb.condition;

import com.bigdata.framework.db.condition.QueryCondition;
import com.bigdata.qqhb.model.Account;
import lombok.Data;

/**
 * @author yang
 * @ClassName: AccountQueryCondition
 * @Description:
 * @date 2018-06-20
 * @version:
 */
@Data
public class AccountQueryCondition extends QueryCondition{
    private Account account;
}
