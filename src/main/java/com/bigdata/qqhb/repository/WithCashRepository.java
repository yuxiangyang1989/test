package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.Withcash;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: WithCashRepository
 * @Description:每日红包提现
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface WithCashRepository extends IBaseRepository<Withcash,String> {
}
