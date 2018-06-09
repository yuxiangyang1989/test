package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.Openvip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: VipRepository
 * @Description:开通vip
 * @date 2018-05-24
 * @version:
 */
public interface VipRepository extends JpaRepository<Openvip, String> {
}
