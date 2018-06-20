package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.Withdrawals;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: WithdrawalsRepository
 * @Description:每日获得红包
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface WithdrawalsRepository extends IBaseRepository<Withdrawals, String> {
}
