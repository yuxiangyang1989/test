package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.Withdrawals;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: WithdrawalsRepository
 * @Description:每日获得红包
 * @date 2018-05-24
 * @version:
 */
public interface WithdrawalsRepository extends JpaRepository<Withdrawals, String> {
}
