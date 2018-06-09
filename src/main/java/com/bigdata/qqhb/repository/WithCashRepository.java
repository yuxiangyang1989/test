package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.Withcash;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: WithCashRepository
 * @Description:每日红包提现
 * @date 2018-05-24
 * @version:
 */
public interface WithCashRepository extends JpaRepository<Withcash,String> {
}
